package numlang;

public class Var extends Expr {
    String name;
    public Var(String name) {
        this.name = name;
    }
    public Double evaluate(Context ctx) throws Exception {
        DoubleOrFuncDecl result = ctx.get(this.name);
        // BAD coding - no error checking.
        return result.number;
    }
    public String toString() {
        return this.name;
    }
}
