package com.example.myapplication;

import android.database.DatabaseErrorHandler;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;

import java.sql.DatabaseMetaData;

public class firebase {
    public static void addListenerForUserUpdate(AppCompatActivity actv){
        DB.getCurrentUserData().addValueEventListener(new ValueEventListener(){

         @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot){
             User.user.updateLists(datasnapshot,actv);
             HomePage.checkBMIChange();
         }
            @Override
            public void onCancelled(@NonNull DatabaseErrorHandler error){

            }

        });
    }
    public static void createUserData(AppCompatActivity context, User user){
        try{
         DB.getCurrentUserName().setValue(user.getName())
         .addFailureListener(new OnFailureListener() {
                @Override
                public void onFailure (@NonNull Exception e){
                    Toast.makeText(context, "Failed to create user record:" + e.getMessage(), Toast.LENGTH_SHORT).show();

                }
            })
            .addOnSuccessListener(new OnSuccessListener<Void>(){
                public void onSuccess(Void aVoid){
                    move(context);
                }
            });
            }catch (Exception e){
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT);
        }
    }
    public static void completeUserData(User user){}
    public static void move(AppCompatActivity context){}
    public static void registration(User user, AppCompatActivity context){
        FirebaseAuth mAuth= FirebaseAuth.getInstance();
        user.setmAuth(mAuth);
        mAuth.createUserWithEmailAndPassword(user.getEmail(), user.getPassword())
                .addOnCompleteListener(context, new OnCompleteListener<AuthResult>(){
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
    public static void login_user(AppCompatActivity context) {
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
    public static DatabaseMetaData getUsers(){
        return FirebaseDatabase.getInstance().getReference("Users");
    }
        public static DatabaseMetaData getCurrentUserData(){
        return getUsers().child(User.user.getmAuth().getCurrentUser().getUid());
    }
        public static DatabaseMetaData getCurrentUserFoods(){
            return getCurrentUserData().child("foods");
    }
        public static DatabaseMetaData getCurrentUserBMIRecords(){
            return getCurrentUserData().child("records");
    }
        public static DatabaseMetaData getCurrentUserName(){
            return getCurrentUserData().child("name");
    }
        public static DatabaseMetaData getCurrentUserGender(){
            return getCurrentUserData().child("gender");
        }
        public static DatabaseMetaData getCurrentUserBirthDate(){
            return getCurrentUserData().child("birthdate");
        }
    }
}