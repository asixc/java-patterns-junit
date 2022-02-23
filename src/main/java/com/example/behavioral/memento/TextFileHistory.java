package com.example.behavioral.memento;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextFileHistory{ // CareTaker
    private static final Map<String, List<TextFileSnapshot>> states = new HashMap<>();

    private TextFileHistory() {
    }

    public static void commit(TextFileOriginator file, String commitMessage) {
        List<TextFileSnapshot> snapshots = states.get(file.getId());
        if (snapshots == null) {
            snapshots = new ArrayList<>();
            states.put(file.getId(), snapshots);
        }

        List<TextFileSnapshot> mementos = states.get(file.getId());
        TextFileSnapshot memento = file.createSnapshot(snapshots.size(), commitMessage);
        mementos.add(memento);
        System.out.println("Commit created: " + file.getName());
    }

    public static void listCommits(TextFileOriginator file) {
        List<TextFileSnapshot> commits = states.get(file.getId());

        if (commits == null || commits.isEmpty()) {
            System.out.println("No commits found: " + file.getName());
            return;
        }
        System.out.println("Commits found: " + file.getName());
        for (TextFileSnapshot commit : commits) {
            System.out.println(commit);
        }
    }

    public static void restore(TextFileOriginator file, int commitSerialNo) {
        List<TextFileSnapshot> commits = states.get(file.getId());
        if (commits != null && commitSerialNo > -1) {
            TextFileSnapshot versionToRestore = commits.get(commitSerialNo);
            file.writeContent(versionToRestore.getContent());

            states.put(file.getId(), commits.subList(0, commitSerialNo));

            System.out.println("Rollback to: " + commitSerialNo);
        }
    }
}
