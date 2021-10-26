package com.company.projagd.view.controller;

/**
 *
 * @author Eduardo Jose Gautier
 */
public class Seguranca {
    public boolean autenticar(String usuario, String senha) {
        return "admin".equals(usuario) && "admin".equals(senha);
    }
}
