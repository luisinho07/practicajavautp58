package model;

import java.util.ArrayList;

public class Wallet {
    public static final int CAPACIDAD_MAXIMA = 1000000; // creación de constante
    private int saldo;
    private boolean tieneLimite;
    private int meta;

    /**
     * Listas (genericidad)
     */
    private ArrayList<Transaction> movimientos;


    /**
     * Creación del constructor
     */
    public Wallet() {
        super();
        saldo = 0;
        tieneLimite = true;
        meta = 0;
        movimientos = new ArrayList<>();
    }

    public int getSaldo(){
        return saldo;
    }

    public boolean getTieneLimite(){
        return tieneLimite;
    }

    public void setTieneLimite(boolean newTieneLimite){
        this.tieneLimite = newTieneLimite;
    }

    public String saveMoney (int value) throws Exception{
        if (saldo + value > CAPACIDAD_MAXIMA && tieneLimite) {
            throw new Exception("No se puede superar el límite" + CAPACIDAD_MAXIMA);
            // return "No se puede superar el límite" + CAPACIDAD_MAXIMA;
        }
        saldo += value; // saldo = saldo + value
        Transaction ingreso = new Transaction(value, "hoy", 1, "Ingreso de dinero");
        movimientos.add(ingreso);
        if (verificarMeta()) {
            System.out.println("Has cumplido la meta!");
        }
        return "Transacción exitosa, nuevo saldo: " + saldo;
    }

    public String takeMoney (int value){
        if (saldo >= value) {
           saldo -= value;
            Transaction retiro = new Transaction(value, "hoy", 2, "Retiro de dinero");
            movimientos.add(retiro);
            return "Transacción exitosa, has retirado: "+ value + " su nuevo saldo es: "+ saldo;
        }
        return "Saldo insuficiente... su saldo es: "+ saldo;
    }

    public String breakLimit(){
        if (!tieneLimite){
            return "Esta cuenta no tiene límite";
        }
        if (saldo > 10000) {
            tieneLimite = false;
            saldo -= 10000;
            Transaction limite = new Transaction(10000, "hoy", 2, "Romper límite");
            movimientos.add(limite);
            return "Se ha quitado el límite de tu billetera, se descuenta 10000 de tu saldo, tu nuevo saldo es: "+ saldo;
        }
        return "No se puede romper el límite, no tiene saldo suficiente";
    }

    public boolean establecerMeta(int value){
        if (value == 0) {
            meta = value;
            return true;    
        }
        if (value < 0 || value <= saldo || (value > CAPACIDAD_MAXIMA && tieneLimite)) {
            return false;
        }
        meta = value;
        return true;
    }

    public boolean verificarMeta(){
        if (meta == 0 || meta > saldo) {
            return false;
        }
        return true;
    }

    public String compararCuenta(Wallet otraWallet){
        if (saldo == otraWallet.getSaldo()) {
            return "Las cuentas tenen el mismo saldo";
        }
        if (saldo > otraWallet.getSaldo()){
            return "La primera cuenta es mayor";
        }
        return "La segunda cuenta es mayor";
    }

    public void displayMovimientos(){
        for (Transaction movimiento : movimientos) {
            System.out.println(movimiento);
        }
    }

}