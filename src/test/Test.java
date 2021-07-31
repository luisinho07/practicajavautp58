package test;

import model.Client;

public class Test {
    
    public static void main(String[] args) {
        Test iniciarPruebas = new Test();
        iniciarPruebas.escenarioClient();
    }

    public void escenarioClient(){
        Client cliente1 = new Client("Luis");

        boolean test1 = assertEquals("Luis", cliente1.getNombre());
        boolean test2 = assertNotNull(cliente1.getWallet()); 
        //if ternario es así: (condition)? responseTrue: responseFalse
        System.out.println((test1)? "Pasó la prueba nombre":"Error, el nombre no es igual");
        System.out.println((test2)? "Wallet existe":"Error, wallet no existe");
    }

    public boolean assertEquals(String expected, String received){

        if (expected.equalsIgnoreCase(received)) {
            return true;
        }
        return false;
    }

    public boolean assertNotNull(Object objeto){
        if (objeto != null) {
            return true;
        }
        return false;
    }

}
