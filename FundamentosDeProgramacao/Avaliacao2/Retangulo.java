public class Retangulo {

    private double altura, base;

    public Retangulo (double altura, double base) {
        
        if (altura>0) this.altura = altura;
        else this.altura = 2;
        if (base>0) this.base = base;
        else this.base = 1;

    }

    public double getBase() {

        return this.base;

    }

    public double getAltura() {

        return this.altura;

    }

    public void setBase(double novaBase) {

        this.base=novaBase;

    }
   
    public void setAltura(double novaAltura) {

        this.altura=novaAltura;

    }

    public double Area() {
        double area;
        area= this.base*this.altura;

        return area;
    }

    public double Perimetro() {
        double perimetro;
        perimetro= (this.base*2) + (this.altura*2);

        return perimetro;
    }

    public double diagonal() {
        double diagonal;
        diagonal= (this.altura*this.altura) + (this.base*this.base);
        
        return diagonal;
    }

    public String toString() {
        return "altura: " + this.altura + "\n base: " + this.base;
        
    }
}
