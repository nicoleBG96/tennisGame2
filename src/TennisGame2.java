
public class TennisGame2 implements TennisGame
{
    public int player1Points = 0;
    public int player2Points = 0;
    
    private String player1Name;
    private String player2Name;
    
    String score = "";

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){
        if (isTie())
			score = getScoreForTie();
        if (isDeuce())
			score = getScoreForDeuce();
        if (isNormal())
        	score = getScoreForNormal();
        advantage();
        win();
        return score;
    }

	private String getScoreForDeuce() {
		return "Deuce";
	}

	private String getScoreForNormal() {
		return getLiteralScore(player1Points) 
				+ "-" 
				+ getLiteralScore(player2Points);
	}

	private String getScoreForTie() {
		return getLiteralScore(player1Points)+ "-All";
	}

	private void win() {
		if (isWinnerOver(player1Points, player2Points))
            score = "Win for player1";
        if (isWinnerOver(player2Points, player1Points))
            score = "Win for player2";
	}

	private boolean isWinnerOver(int firstPlayerPoints, int secondPlayerPoints) {
		return firstPlayerPoints>=4 && secondPlayerPoints>=0 && (firstPlayerPoints-secondPlayerPoints)>=2;
	}

	private void advantage() {
		if (isPlayerInAdvantageOver(player1Points, player2Points))
            score = "Advantage player1";
        if (isPlayerInAdvantageOver(player2Points, player1Points))
            score = "Advantage player2";
	}

	private boolean isPlayerInAdvantageOver(int firstPlayerPoints, int secondPlayerPoints) {
		return firstPlayerPoints > secondPlayerPoints && secondPlayerPoints >= 3;
	}


	private boolean isNormal() {
		return player1Points !=player2Points  && 
				(player1Points<4 || player2Points<4);
	}

	private String getLiteralScore(int playerPoints) {
		String result="";
		if (playerPoints==0)
		    result = "Love";
		if (playerPoints==1)
		    result = "Fifteen";
		if (playerPoints==2)
		    result = "Thirty";
		if (playerPoints==3)
		    result = "Forty";
		return result;
	}

	private boolean isDeuce() {
		return player1Points==player2Points && player1Points>=3;
	}

	private boolean isTie() {
		return player1Points == player2Points && player1Points < 4;
	}
    
    public void setPoint(String player) {
        if (player == "player1")
			player1Points++;
		else
			player2Points++;
    }
}