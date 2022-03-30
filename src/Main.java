public class Main {

    public static void main(String[] args) {
        Cliente sara = new Cliente();
        sara.setNome("Sara Oliveira");



        Conta cc = new ContaCorrente(sara);
        Conta poupanca = new ContaPoupanca(sara);

        cc.depositar(1000);
        cc.transferir(200, poupanca);


        cc.imprimirExtrato();
        poupanca.imprimirExtrato();


    }

}
