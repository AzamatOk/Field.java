package com.azamat.tictactoe;

import java.util.Arrays;

public class Field {
   private final String[] storage = new String[] {"-", "-", "-", "-", "-", "-", "-", "-", "-"};

   public String[] getStorage() {
      return storage;
   }



   public void setItem(int index, String value) {
      this.storage[index] = value;

   }

   public String getItemValue(int index) {
      return this.storage[index];
   }

   public void showField() {
      getStorage();
      for (int i = 0; i < 9; i++)
      {
         System.out.print(storage[i]);
         if (i == 2 || i == 5 || i == 8){
            System.out.println();
         }
      }

   }
}
