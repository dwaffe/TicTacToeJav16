public abstract class Pawn {
    public abstract String getName();
    public abstract String getSign();

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Pawn) {
            return ((Pawn)obj).getSign().equals(this.getSign());
        }

        return super.equals(obj);
    }
}
