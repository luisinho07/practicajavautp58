package model;

public class Wallet {
    public static final int CAPACIDAD_MAXIMA = 1000000; // creación de constante
    private int saldo;
    private boolean tieneLimite;
    
    // creación constructor con palabra: ctor
    public Wallet() {
        super();
        saldo = 0;
        tieneLimite = true;
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

    public String saveMoney (int value){
        if (saldo + value > CAPACIDAD_MAXIMA && tieneLimite) {
            return "No se puede superar el límite" + CAPACIDAD_MAXIMA;
        }
        saldo += value; // saldo = saldo + value
        return "Transacción exitosa, nuevo saldo: " + saldo;

    }

    public String giveMoney (int value){
        if (saldo <= value) {
            return "Saldo insuficiente... su saldo es: "+ saldo;
        }
        saldo -= value;
        return "Transacción exitosa, has retirado: "+ value + "su nuevo saldo es: "+ saldo;
    }

    public String breakLimit(){
        if (!tieneLimite){
            return "Esta cuenta no tiene límite";
        }
        if (saldo > 10000) {
            tieneLimite = false;
            saldo -= 10000;
            return "Se ha quitado el límite de tu billetera, se descuenta 10000 de tu saldo, tu nuevo saldo es: "+ saldo;
        }
        return "No se puede romper el límite, no tiene saldo suficiente";
    }

}