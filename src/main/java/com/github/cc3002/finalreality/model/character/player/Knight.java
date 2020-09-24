package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

public class Knight extends AbstractCharacter {
    public Knight(@NotNull String name,
                  @NotNull BlockingQueue<ICharacter> turnsQueue,
                  int healthPoints,
                  int defense){
        super(name,"Knight",turnsQueue,healthPoints,defense);
    }
}