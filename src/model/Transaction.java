package model;

public class Transaction {
    private int amount;
    private String fecha;

    /*
    * tipo de transacción
    * 1 Ingreso de dinero
    * 2 Retiro de dinero
    */
    private int type;
    private String description;

    /**
     * Método que construye un objeto de la clase Transaction <br>
     * @param amount valor del movimiento
     * @param fecha fecha en la que se realiza el movimiento
     * @param type tipo de movimiento 1==ingreso, 2== retiro
     * @param description descripción del movimiento
     */

    public Transaction(int amount, String fecha, int type, String description) {
        super();
        this.amount = amount;
        this.fecha = fecha;
        this.type = type;
        this.description = description;
    }

    /**
     * Retorna el valor del movimiento
     * @return amount
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Retorna la fecha del movimiento
     * @return fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Retorna el tipo del movimiento
     * @return type
     */
    public int getType() {
        return type;
    }

    /**
     * Retorna la descripción del movimiento
     * @return description
     */
    public String getDescription(){
        return description;
    }

    /**
     * 
     */
    public String toString(){
        return "Monto: "+ amount + " Fecha: "+ fecha + " Tipo: "+ ((type==1)?"Ingeso":"Egreso") + " Descripción: " + description;
    }

}
