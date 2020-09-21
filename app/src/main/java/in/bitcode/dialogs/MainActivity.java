package in.bitcode.dialogs;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mBtnAlertDialog, mBtnDatePickerDialog, mBtnTimePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setContentView(R.layout.activity_main);
        init();

        mBtnAlertDialog.setOnClickListener(new BtnAlertDialogClickListener());


    }

    private class BtnAlertDialogClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);

            alertDialogBuilder.setTitle(R.string.alert_dialog_title);
            alertDialogBuilder.setMessage(R.string.alert_dialog_message);
            alertDialogBuilder.setIcon(R.mipmap.ic_launcher);

            //set up buttons for dialog
            /*
            alertDialogBuilder.setPositiveButton(R.string.alert_dialog_positive_button_text, new BtnPositiveClickListener());
            alertDialogBuilder.setNegativeButton(R.string.alert_dialog_negative_button_text, new BtnNegativeClickListener());
            alertDialogBuilder.setNeutralButton(R.string.alert_dialog_neutral_button_text, new BtnNeutralClickListener());
            */

            OptionsButtonClickListener optionsButtonClickListener =
                    new OptionsButtonClickListener();
            alertDialogBuilder.setPositiveButton(R.string.alert_dialog_positive_button_text, optionsButtonClickListener);
            alertDialogBuilder.setNegativeButton(R.string.alert_dialog_negative_button_text, optionsButtonClickListener);
            alertDialogBuilder.setNeutralButton(R.string.alert_dialog_neutral_button_text, optionsButtonClickListener);

            alertDialogBuilder.setCancelable(true);
            alertDialogBuilder.setOnCancelListener(
                    new DialogInterface.OnCancelListener() {
                        @Override
                        public void onCancel(DialogInterface dialogInterface) {
                            mt("You cancelled the dialog!");
                        }
                    }
            );

            alertDialogBuilder.setOnDismissListener(
                    new DialogInterface.OnDismissListener() {
                        @Override
                        public void onDismiss(DialogInterface dialogInterface) {
                            mt("You dismissed the dialog!");
                        }
                    }
            );

            AlertDialog alertDialogJob = alertDialogBuilder.create();
            alertDialogJob.show();
        }
    }

    private class OptionsButtonClickListener implements DialogInterface.OnClickListener {
        @Override
        public void onClick(DialogInterface dialogInterface, int which) {
            switch (which) {
                case DialogInterface.BUTTON_POSITIVE:
                    mt("You left Google!");
                    break;
                case DialogInterface.BUTTON_NEGATIVE:
                    mt("Good to see you!");
                    break;
                case DialogInterface.BUTTON_NEUTRAL:
                    mt("You are confused...");
                    break;
            }
        }
    }

    private class BtnPositiveClickListener implements DialogInterface.OnClickListener {
        @Override
        public void onClick(DialogInterface dialogInterface, int which) {
            mt("You left Google!");
        }
    }

    private class BtnNegativeClickListener implements DialogInterface.OnClickListener {
        @Override
        public void onClick(DialogInterface dialogInterface, int which) {
            mt("Good to see you!");
        }
    }

    private class BtnNeutralClickListener implements DialogInterface.OnClickListener {
        @Override
        public void onClick(DialogInterface dialogInterface, int which) {
            mt("You are confused, as usual!");
        }
    }

    private void init() {
        mBtnAlertDialog = findViewById(R.id.btnAlertDialog);
        mBtnDatePickerDialog = findViewById(R.id.btnDatePickerDialog);
        mBtnTimePickerDialog = findViewById(R.id.btnTimePickerDialog);
    }

    private void mt(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }
}