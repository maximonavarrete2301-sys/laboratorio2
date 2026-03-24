import java.util.Scanner;
class PabellonCirugia {
    private int numero;
    private String especialidad;
    private Estado estado;

    public PabellonCirugia(int num, String especialidad) {
        this.numero = num;
        this.especialidad = especialidad;
        this.estado = Estado.DISPONIBLE;
    }
    public int getNumero() {
        return numero;
    }
    public String getEspecialidad() {
        return especialidad;
    }
    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String toString() {
        return this.numero + "," + this.especialidad + "," + this.estado.name().toLowerCase();
    }
    public boolean equals(Object otro) {
        if (this == otro) return true;
        if (otro == null || getClass() != otro.getClass()) return false;

        PabellonCirugia pabellon = (PabellonCirugia) otro;
        return this.numero == pabellon.numero;
    }
}

public class DemoPabellonCirugia {
    private PabellonCirugia[] pabellones;
    public DemoPabellonCirugia() {
        this.pabellones = new PabellonCirugia[6];
    }
    public void procesa() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingreso de pabellones [6]");
        for (int i = 0; i < 6; i++) {
            System.out.println("Pabellon " + (i + 1) + ":");

            int num = -1;
            while (num <= 0) {
                System.out.print("Número de pabellon: ");
                if (scanner.hasNextInt()) {
                    num = scanner.nextInt();
                } else {
                    System.out.println("Error. Ingrese número valido");
                    scanner.next();
                }
            }
            scanner.nextLine();
            String esp = "";
            while (esp.trim().isEmpty()) {
                System.out.print("Especialidad: ");
                esp = scanner.nextLine();
                if (esp.trim().isEmpty()) {
                    System.out.println("Error: Debe ingresar una especialidad");
                }
            }

            this.pabellones[i] = new PabellonCirugia(num, esp);
        }

        for (int i = 0; i < this.pabellones.length; i++) {
            if (i % 2 == 0) {
                this.pabellones[i].setEstado(Estado.OCUPADO);
            }
        }

        System.out.println("LISTA DE PABELLONES");
        for (PabellonCirugia p : this.pabellones) {
            System.out.println(p.toString());
        }

        System.out.println("\n--- VALIDACIÓN DE PABELLONES IGUALES ---");
        boolean hayIguales = false;

        for (int i = 0; i < this.pabellones.length - 1; i++) {
            for (int j = i + 1; j < this.pabellones.length; j++) {
                if (this.pabellones[i].equals(this.pabellones[j])) {
                    System.out.println("Los pabellones en las posiciones " + i + " y " + j + " tienen el mismo numero.");
                    hayIguales = true;
                }
            }
        }
        if (!hayIguales) {
            System.out.println("No hay pabellones con numeros iguales");
        }
        scanner.close();
    }
    public static void main(String[] args) {
        DemoPabellonCirugia demo = new DemoPabellonCirugia();
        demo.procesa();
    }
}
