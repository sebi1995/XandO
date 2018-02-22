import java.util.ArrayList;

public class Table {

    private ArrayList<marks> table;
    private boolean turn;

    public enum marks {mX, mO, m_}

    Table(boolean turn) {
        this.table = populatesTable();
        this.turn = turn;
    }

    private ArrayList<marks> populatesTable() {
        ArrayList<marks> map = new ArrayList<>();
        for (int i = 0; i < 9; ++i) {
            map.add(marks.m_);
        }
        return map;
    }

    public boolean addsToTable(int position, marks mark) {
        if (position >= 1 && position <= 9) {
            if (table.get(position - 1) == marks.m_) {
                table.set(position - 1, mark);
                turn = !turn;
                return true;
            }
        }
        return false;
    }

    public void printsTable() {
        for (int i = 0; i < 9; i++) {
            switch (table.get(i)) {
                case mX:
                    System.out.print("\033[1;34m" + "X " + "\033[0m");
                    break;
                case m_:
                    System.out.print((i + 1) + " ");
                    break;
                case mO:
                    System.out.print("\033[1;31m" + "O " + "\033[0m");
                    break;
            }
            if (i == 2 || i == 5) System.out.println();
        }
        System.out.println();
    }

    private marks checksWhoWon(marks m) {
        if (table.get(0) == m && table.get(1) == m && table.get(2) == m ||
                table.get(3) == m && table.get(4) == m && table.get(5) == m ||
                table.get(6) == m && table.get(7) == m && table.get(8) == m ||
                table.get(0) == m && table.get(3) == m && table.get(6) == m ||
                table.get(1) == m && table.get(4) == m && table.get(7) == m ||
                table.get(2) == m && table.get(5) == m && table.get(8) == m ||
                table.get(0) == m && table.get(4) == m && table.get(8) == m ||
                table.get(2) == m && table.get(4) == m && table.get(6) == m) {
            return m;
        }
        return marks.m_;
    }

    public boolean checksBoardIfDraw() {
        return !table.get(0).equals(marks.m_) && !table.get(1).equals(marks.m_) && !table.get(2).equals(marks.m_) &&
                !table.get(3).equals(marks.m_) && !table.get(4).equals(marks.m_) && !table.get(5).equals(marks.m_) &&
                !table.get(6).equals(marks.m_) && !table.get(7).equals(marks.m_) && !table.get(8).equals(marks.m_);
    }

    public int checksBoardIfGameOver(marks m) {
        switch (checksWhoWon(m)) {
            case mX:
                return 1;
            case mO:
                return 2;
            default:
                return 0;
        }
    }

    public boolean getTurn() {
        return turn;
    }
}


//https://github.com/sebi1995/XandO.git
