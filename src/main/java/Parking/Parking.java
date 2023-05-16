/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Parking;

import java.util.ArrayList;

/**
 *
 * @author rubenpengim
 */
public class Parking {
    private ArrayList<String> matriculas;
    private String nombre;

    public Parking(String nombre, int numPlazas) {
        this.nombre = nombre;
        this.matriculas = new ArrayList<>(numPlazas);
        for (int i = 0; i < numPlazas; i++) {
            this.matriculas.add(null);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void entrada(String matricula, int plaza) throws Exception {
        if (matricula == null || matricula.length() < 4) {
            throw new Exception("Matrícula incorrecta");
        }

        if (plaza < 0 || plaza >= matriculas.size()) {
            throw new Exception("Plaza ocupada");
        }

        if (matriculas.contains(matricula)) {
            throw new Exception("Matrícula repetida");
        }

        if (matriculas.get(plaza) != null) {
            throw new Exception("Plaza ocupada");
        }

        matriculas.set(plaza, matricula);
    }

    public int salida(String matricula) throws Exception {
        if (!matriculas.contains(matricula)) {
            throw new Exception("Matrícula no existente");
        }

        int plazaLiberada = matriculas.indexOf(matricula);
        matriculas.set(plazaLiberada, null);
        return plazaLiberada;
    }

    public int getPlazasTotales() {
        return matriculas.size();
    }

    public int getPlazasOcupadas() {
        int count = 0;
        for (String matricula : matriculas) {
            if (matricula != null) {
                count++;
            }
        }
        return count;
    }

    public int getPlazasLibres() {
        return matriculas.size() - getPlazasOcupadas();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nombre).append("\n");
        for (int i = 0; i < matriculas.size(); i++) {
            sb.append("Plaza ").append(i).append(": ");
            if (matriculas.get(i) != null) {
                sb.append(matriculas.get(i));
            } else {
                sb.append("(vacía)");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}