package com.example.recipesmanager;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.Serializable;

public class Details extends AppCompatActivity {

    DB_Sqlite mydata = new DB_Sqlite(Details.this);
    TextView tvtitre;
    TextView tvid;
    TextView tvtype;
    TextView tvtnbpersonnes;
    TextView tvniveau;
    TextView tvingredients;
    TextView tvinstruction;
    ImageView tvimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent i = getIntent();
        int selectedid = getIntent().getExtras().getInt("selectedid");

        Recette recette = mydata.getRecetteById(selectedid);

        tvtitre = findViewById(R.id.titre);
        tvtitre.setText(recette.getTitre());

        tvtitre = findViewById(R.id.id);
        String tmpid = String.valueOf(recette.getId());
        tvtitre.setText(tmpid);

        tvtype = findViewById(R.id.type);
        tvtype.setText(recette.getType());


        tvtnbpersonnes = findViewById(R.id.nbpersonnes);
        tvtnbpersonnes.setText(String.valueOf(recette.getNbpersonnes()));

        tvniveau = findViewById(R.id.niveau);
        tvniveau.setText(recette.getNiveau());

        tvingredients = findViewById(R.id.ingredients);
        tvingredients.setText(recette.getIngredients());

        tvinstruction = findViewById(R.id.instruction);
        tvinstruction.setText(recette.getInstruction());

        tvimage = (ImageView) findViewById(R.id.image);
        tvimage.setImageBitmap(BitmapFactory.decodeFile(recette.getImage()));



        Toast.makeText(Details.this,recette.getImage(),Toast.LENGTH_SHORT).show();


    }

    public void btn_delete(View view) {
        TextView tvid = findViewById(R.id.id);
        int id = Integer.parseInt(String.valueOf(tvid.getText()));

        DB_Sqlite mydb = new DB_Sqlite(Details.this);

        AlertDialog diaBox = AskOption(id, mydb);
        diaBox.show();

    }

    private AlertDialog AskOption(int id, DB_Sqlite db) {
        AlertDialog myQuittingDialogBox = new AlertDialog.Builder(this)
                .setTitle("Supprimer")
                .setMessage("Voulez-vous supprimer ?")
                .setPositiveButton("Supprimer", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int whichButton) {
                        db.deleteOne(id);
                        Intent tomain = new Intent(Details.this, MainActivity.class);
                        startActivity(tomain);
                        finish();
                        dialog.dismiss();
                    }

                })
                .setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();
                    }
                })
                .create();
        return myQuittingDialogBox;
    }


    public void btn_modify(View view) {

        tvid = findViewById(R.id.id);
        int id = Integer.parseInt(tvid.getText().toString());

        Intent intent = new Intent(Details.this, Modify.class);
        intent.putExtra("id", id);
        startActivity(intent);
        finish();
    }
}