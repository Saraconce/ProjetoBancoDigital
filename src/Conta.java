public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 131;
    private static double SEQUENCIAL = 3293566;

    protected int agencia;
    protected int numero;
    protected double saldo;

    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = (int) SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }



    protected void imprimirInfosCC() {
        System.out.println("=== Extrato ===");
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d \n", this.numero));
        System.out.println("Conta Corrente ");
        System.out.println(String.format("Saldo: %.2f \n", this.saldo));

    }

    protected void imprimirInfosP() {
        System.out.println("Conta Poupança ");
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }
}