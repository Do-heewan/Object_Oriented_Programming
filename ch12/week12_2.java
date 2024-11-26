package ch12;

class week12_2 extends Converter{
    public week12_2(double ratio) {
        this.ratio = ratio;
    }

    protected double convert(double src) {
        return src / ratio;
    }

    protected String srcString() {
        return "Km";
    }

    protected String destString() {
        return "mile";
    }

    public static void main(String[] args) {
        week12_2 toMile = new week12_2(1.6); // 1마일은 1.6km
        toMile.run();
    }
}

