package com.example.myapplication;

import com.google.android.gms.tasks.OnCompleteListener;

public class firebase {
    public static void addListenerForUserUpdate(AppCompleteActivity actv){
        DB.getCurrentUserData().addValueEventListener(new ValueEventListener(){
         @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot){
             User.user.updateLists(datasnapshot,actv);
             HomePage.checkBMIChange();
         }
            @Override
            public void onCancelled(@NonNull DatabaseError error){

            }

        });
    }
    public static void createUserData(AppCompleteActivity context, User user){
        try{
         DB.getCurrentUserName().setValue(user.getName())
         .addFailureListener(){
                @Override
                public void onFailure(@NonNull Exception e){

                }

            }
        }
    }
    public static void completeUserData(User user){}
    public static void move(AppCompleteActivity context){}
    public static void registration(User user, AppCompleteActivity context){
        FirebaseAuth mAuth= FirebaseAuth.getInstance();
        user.setmAuth(mAuth);
        mAuth.createUserWithEmailAndPassword(user.getEmail(), user.getPassword())
                .addOnCompleteListener(context, new OnCompleteListener<AuthResult>()){
            @Override
              public void onComplete(@NonNull Task<AuthResult> task){
                if (task.isSuccessful()){
                    createUserData(context,user);
                }
                else{
                    Toast.makeText(context,"Error, cant add user to firebase:" +task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public static void login_user(AppCompleteActivity context) {
        try {
            User.user.setmAuth(FirebaseAuth.getInstance());
            User.user.getmAuth().signInWithEmailAndPassword(User.user.getEmail(), User.user.getPassword())
                    .addOnCompleteListener(context, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull com.google.android.gms.tasks.Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                User.user.setmAuth(FirebaseAuth.getInstance());
                                addListenerForUserUpdate(context);
                                DB.getCurrentUserData().child("login").setValue(new Date().toString());
                                Intent x;
                                if (User.user.isNewUser())
                                    x = new Intent(context, complete_profile.class);
                                else
                                    x = new Intent(context, HomePage.class);
                                context.startActivity(x);
                                context.finish();
                            } else {
                                Toast.makeTest(context, "Invalid email or password", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        } catch (Exception e) {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public static void logout(){
        User.user.getmAuth().signOut();
    }
    public static void addBMIRecord(BMIRecord record){
        String key= DB.getCurrentUserBMIRecords().push().getKey();
        record.setId(key);
        DB.getCurrentUserBMIRecords().child(key).setValue(record);
    }
    public static void removeBMIRecord(BMIRecord record){
        DB.getCurrentUserBMIRecords().child(key).removeValue();
    }
    public static void addFood(Food record){
        String key= DB.getCurrentUserFoods().push().getKey();
        record.setId(key);
        DB.getCurrentUserFoods().child(key).setValue(record);
    }
    public static void removeFood(Food record){
        DB.getCurrentUserFoods().child(record.getId()).removeValue();
    }
    public static class DB{
    public static DatabaseReference getUsers(){
        return FirebaseDatabase.getInstance().getReference("Users");
    }
        public static DatabaseReference getCurrentUserData(){
        return getUsers().child(User.user.getmAuth().getCurrentUser().getUid());
    }
        public static DatabaseReference getCurrentUserFoods(){
            return getCurrentUserData().child("foods");
    }
        public static DatabaseReference getCurrentUserBMIRecords(){
            return getCurrentUserData().child("records");
    }
        public static DatabaseReference getCurrentUserName(){
            return getCurrentUserData().child("name");
    }
        public static DatabaseReference getCurrentUserGender(){
            return getCurrentUserData().child("gender");
        }
        public static DatabaseReference getCurrentUserBirthDate(){
            return getCurrentUserData().child("birthdate");
        }
    }
}