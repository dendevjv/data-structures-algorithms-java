package dsalgjava.ch06.progproj.pp0605;

public class Group {
    private char[] charArr;

    Group(int size) {
        charArr = makeCharArray(size);
    }

    private static char[] makeCharArray(int size) {
        char[] array = new char[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = (char) ('A' + i);
        }
        return array;
    }

    void showTeams(int teamSize) {
        recursiveShowTeams("", 0, charArr.length, teamSize);
    }

    private void recursiveShowTeams(String prefix, int recursionLevel,
            int groupSize, int teamSize) {
        if (teamSize == 0) {
            System.out.println(prefix);
            return;
        } else if (groupSize < teamSize) {
            return;
        }
        recursionLevel++;
        groupSize--;
        recursiveShowTeams(prefix + charArr[recursionLevel], recursionLevel,
                groupSize, teamSize - 1);
        recursiveShowTeams(prefix, recursionLevel, groupSize, teamSize);
    }
}
