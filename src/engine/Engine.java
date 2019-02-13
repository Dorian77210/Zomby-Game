package engine;

import engine.control.Keyboard;

public class Engine {

    private static Engine engine;

    private Keyboard keyboard;

    private Engine() {
        this.keyboard = new Keyboard();
    }

    public static Engine instance() {
        if(engine == null) {
            engine = new Engine();
        }

        return engine;
    }

    public Keyboard getKeyboard() {
        return this.keyboard;
    }
}