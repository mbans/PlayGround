package com.lumar.playground.pattern.templatemethod;

import com.lumar.playground.domain.GoldenToken;
import com.lumar.playground.domain.SilverToken;
import com.lumar.playground.domain.Token;



/**
 * Template Method pattern, which defines a stub for an algorithm, 
 * deferring some implementation steps to subclasses.
 * 
 * Application:
 * 	(i)  Define template to build a house, we define order in which things are built, defer implemtation to subclass
 *  (ii) Validation Framework, define the structure but based on actual of the "Trade" we will have a different implemtation
 * 
 * Where I have used: 
 *  (i) RBS - when we recive trades from ODC (tradestore) we had a number of rules which we ran over the trades
 *      However, the logic of these rules depended on the trade type, so we had "IRDVerifier", "FXVerifier" etc 
 *      The specific delegated to the subclasses, however common verification logic was held within the Template/Subclass 
 * 
 * Example Below:
 * In the below example we have a different verification stategy based on the Token type.
 * We delegate the verification of each to a specific subclass, however the overall verification algorithm is set in stone
 * within the "TemplateValidationTemplate"   
 *   
 */
public class TemplateMethodPatternExample {

	public static void main(String[] args) {
		
		Token gold = new GoldenToken("1","1",1); 
		Token silver = new SilverToken("1","1",1); 

		TokenValidationTemplate goldVerification = new GoldTokenVerification();
		goldVerification.validate(gold);
		goldVerification.validate(silver);
		
		TokenValidationTemplate silverVerification = new SilverTokenVerification();
		silverVerification.validate(silver);
		silverVerification.validate(gold);
	}
}
