package com.example.trabalho2;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.ArrayList;
import java.util.List;


public class ListDialog extends DialogFragment implements DialogInterface.OnClickListener {

    private EditText edit_item;
    private OnInteractionListener mListener;
    private String item;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.titleDialog);

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View layout = inflater.inflate(R.layout.list_dialog, null);

        builder.setView(layout);

        edit_item = layout.findViewById(R.id.edit_item);

        builder.setPositiveButton(R.string.positive, this);
        builder.setNegativeButton(R.string.negative, this);

        return builder.create();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        if (which == DialogInterface.BUTTON_POSITIVE){
            if (mListener != null){
                 item = edit_item.getText().toString();
                mListener.onInteraction(item);
            }
        }
        else if (which == DialogInterface.BUTTON_NEGATIVE){
            Toast.makeText(getActivity(), R.string.itemCancel, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnInteractionListener){
            mListener = (OnInteractionListener) context;
        }else{
            throw new RuntimeException(context.toString() + "erro");
        }
    }
    public interface OnInteractionListener{
        void onInteraction(String texto);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}
