package Validation;

import org.testng.Assert;
import org.testng.annotations.Test;

import Payload.Team;
import io.restassured.path.json.JsonPath;

public class Testing {

	@Test
	public void ForeignPlayers()
	{
		JsonPath js = new JsonPath(Team.TeamRCB());
		int count = js.getInt("player.size()");
		
		int x=0;
		for(int i=0; i<count; i++)
		{
			String PlayerCountry = js.getString("player["+i+"].country");
		
			if(PlayerCountry.equalsIgnoreCase("India"))
			{
				x = x+1;
			}
		}
		if(x==7)
		{
			System.out.println("Team Has Only 4 Foreign Players");
			Assert.assertTrue(true);
		}
		else
		{
			System.out.println("Team Has More Than 4 Foreign Players");
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void Wicketkeeper()
	{
		JsonPath js = new JsonPath(Team.TeamRCB());
		int count = js.getInt("player.size()");
		
		int x=0;
		for(int i=0; i<count; i++)
		{
			String PlayerCountry = js.getString("player["+i+"].role");
		
			if(PlayerCountry.equalsIgnoreCase("Wicket-keeper"))
			{
				x = x+1;
			}
		}
		if(x>=1)
		{
			System.out.println("Team Has Wicket-Keeper");
			Assert.assertTrue(true);
		}
		else
		{
			System.out.println("Team Has NO Wicket-Keeper");
			Assert.assertTrue(false);
		}
	}
}
