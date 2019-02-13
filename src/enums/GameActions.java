package enums;

public enum GameActions {
    MOVE_UP {
        public String toString() {
            return "Forward";
        }
    },

    MOVE_DOWN {
        public String toString() {
            return "Backward";
        }
    },
    MOVE_RIGHT {
        public String toString() {
            return "Right";
        }
    },
    MOVE_LEFT {
        public String toString() {
            return "Left";
        }
    },
    SHOOT {
        public String toString() {
            return "Shoot";
        }
    }
}