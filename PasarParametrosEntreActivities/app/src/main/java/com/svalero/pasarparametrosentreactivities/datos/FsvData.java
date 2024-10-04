package com.svalero.pasarparametrosentreactivities.datos;

import com.svalero.pasarparametrosentreactivities.beans.Usuario;

import java.util.ArrayList;

public class FsvData {
    private static Usuario usuario;
    private static ArrayList<Usuario> ListaUsuarios;

    public static Usuario getUsuario() {
        return usuario;
    }

    public static void setUsuario(Usuario usuario) {
        FsvData.usuario = usuario;
    }
}
