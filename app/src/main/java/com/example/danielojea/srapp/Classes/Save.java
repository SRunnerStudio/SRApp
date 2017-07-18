package com.example.danielojea.srapp.Classes;

import com.example.danielojea.srapp.control.CharacterSelectionContentProvider;

import java.util.List;

/**
 * Created by Daniel on 18.07.2017.
 */

public class Save {
    List<CharacterSelectionContentProvider.CharacterItem> characterList;

    public Save(List<CharacterSelectionContentProvider.CharacterItem> characterList) {
        this.characterList = characterList;
    }

    public List<CharacterSelectionContentProvider.CharacterItem> getCharacterList() {
        return characterList;
    }

    public void setCharacterList(List<CharacterSelectionContentProvider.CharacterItem> characterList) {
        this.characterList = characterList;
    }
}
