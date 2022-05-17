# tic-tac-toe
Tic-tac-toe in Java

## Panels Documentation

**Main Window**:  
```java 
view.switchMainPanel() - Swap between Hall of Fame and Game Board
```
**Hall of Fame:**
```java 
view.getHofPanel() - Get entire Panel
view.getHofPanel().setPlayer(int position, String player, int score) - In Hall of Fame set a player in a position with a score
view.getHofPanel().setHofVisible(boolean state) - Set visibility of panel (to switch between Hall of Fame and Game Board)
```
**Game Board:**
```java
view.getBoardPanel() - Get entire Panel
view.getBoardPanel().setMessage(String message) - Set message to be shown in top of panel
view.getBoardPanel().getTable() - Get board table (mainly to add listener)
view.getBoardPanel().setCell(int x, int y, int player) - Set a move on specific cell x,y (player = 1: X, player = 2: O)
view.getBoardPanel().setBoardVisible(boolean state) - Set visibility of panel (to switch between Hall of Fame and Game Board)
view.getBoardPanel().resetBoard() - Resets board to empty
```
