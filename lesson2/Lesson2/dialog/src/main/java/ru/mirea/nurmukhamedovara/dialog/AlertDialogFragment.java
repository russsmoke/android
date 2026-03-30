package ru.mirea.nurmukhamedovara.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class AlertDialogFragment extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Создаем строитель диалога
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        // Настраиваем диалог
        builder.setTitle("Здравствуй МИРЭА!")
                .setMessage("Успех близок?")
                .setIcon(android.R.drawable.ic_dialog_info)
                .setPositiveButton("Иду дальше", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        if (getActivity() instanceof MainActivity) {
                            ((MainActivity) getActivity()).onOkClicked();
                        }
                        dialog.dismiss();
                    }
                })
                .setNeutralButton("На паузе", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        if (getActivity() instanceof MainActivity) {
                            ((MainActivity) getActivity()).onNeutralClicked();
                        }
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("Нет", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        if (getActivity() instanceof MainActivity) {
                            ((MainActivity) getActivity()).onCancelClicked();
                        }
                        dialog.dismiss();
                    }
                });
        return builder.create();
    }
}