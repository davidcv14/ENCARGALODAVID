package mx.com.encargalo.tendero.Inicio_sesion.ui.Mis_ordenes;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupMenu;

import mx.com.encargalo.R;

public class mio_frgdetalleproducto extends Fragment {
    Button mio_dpbtncancelarorden,mio_dpbtnenviarorden;
    Dialog dialog;
    View confirmacion, cancelacion;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_mio_frgdetalleproducto, container, false);
        mio_dpbtncancelarorden=vista.findViewById(R.id.mio_dpbtncancelarorden);
        mio_dpbtnenviarorden=vista.findViewById(R.id.mio_dpbtnenviarorden);
        mio_dpbtncancelarorden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelacion=v;
                elegirAccion();
            }
        });
        mio_dpbtnenviarorden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmacion=v;
                enviarorden();
            }
        });

        return vista;
    }

    private void enviarorden() {
        dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.mio_lytenviarorden);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.setCancelable(false);
        Button ecancelar = dialog.findViewById(R.id.mio_eobtncancelar);
        ecancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        Button eenviar = dialog.findViewById(R.id.mio_eobtnaceptar);
        eenviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(confirmacion).navigate(R.id.nav_misordenesconfirmacion);
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private void elegirAccion() {
        dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.mio_lytcancelarorden);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.setCancelable(false);
        final Button cancelar = dialog.findViewById(R.id.mio_cobtncancelar);
        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        Button aceptar = dialog.findViewById(R.id.mio_cobtnaceptar);
        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(cancelacion).navigate(R.id.nav_misordenesdetallepedido);
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}