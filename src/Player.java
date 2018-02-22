public class Player {

    private String name;
    private Table table;
    private Table.marks mark;
    private int playerNumber;

    Player(Table table, String name, boolean markBool) {
        this.table = table;
        this.name = name;
        this.mark = hasMark(markBool);
        this.playerNumber = hasMark(markBool) == Table.marks.mX ? 1 : 2;
    }

    private Table.marks hasMark(boolean whatMark) {
        if (whatMark){
            return Table.marks.mX;
        } else
            return Table.marks.mO;
    }

    public boolean playsTurn(int position) {
        return table.addsToTable(position, mark);
    }

    public Table.marks getMark() {
        return mark;
    }

    public String getName() {
        return name;
    }

    public boolean checksIfWon(){
        return table.checksBoardIfGameOver(getMark()) == playerNumber;
    }
}

//https://github.com/sebi1995/XandO.git