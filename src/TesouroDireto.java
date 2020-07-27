public class TesouroDireto {
    private int anos;
    private double juros;
    private double depositoMensal;

    public TesouroDireto(int a, double j, double dm) {
        anos = a;
        juros = j / 100;
        depositoMensal = dm;
    }

    public double calculaTotal() {
        int num_pagamentos = anos * 12;
        double total = 0;
        for (int i = 0; i < num_pagamentos; i++) {
            total = total + depositoMensal;
            total = total + total * juros;
        }
        return total;
    }

}