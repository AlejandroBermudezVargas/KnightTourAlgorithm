public class Pila {

    NodoPila primero = null;

    public Pila() {
    }

    public boolean isEmpty() {
        return primero == null;
    }

    public void push(Object o) {
        NodoPila nuevo = new NodoPila(o);
        nuevo.setSgte(primero);
        primero = nuevo;
    }

    public Object pop() {
        if (!isEmpty()) {
            NodoPila act = primero;
            primero = primero.getSgte();
            return act.getDato();
        }
        return null;
    }

    public void append(Pila stack) {
        if (stack.isEmpty()) {
            return;
        }
        NodoPila act = stack.getTop();
        while (act.getSgte() != null) {
            act = act.getSgte();
        }
        act.setSgte(this.primero);
        this.primero = stack.getTop();
    }

    public NodoPila getTop() {
        return primero;
    }
}
