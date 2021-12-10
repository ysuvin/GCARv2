// $ANTLR null C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g 
package parser;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class AlgebraRelacionalParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "CAD", "NUM", "WS", "'!='", "'('", 
		"')'", "','", "'-'", "'.'", "':='", "'<'", "'<='", "'='", "'>'", "'>= '", 
		"'AGRUPAR'", "'AND'", "'AVG'", "'COUNT'", "'CRUZ'", "'DIFERENCIA'", "'DIVISION'", 
		"'INTER'", "'MAX'", "'MIN'", "'OR'", "'ORDENAR'", "'PROYECTAR'", "'RENOMBRAR'", 
		"'REUNION'", "'REUNION_EXT_DER'", "'REUNION_EXT_FULL'", "'REUNION_EXT_IZQ'", 
		"'REUNION_NATURAL'", "'SELECCIONAR'", "'SUM'", "'UNION'", "'\\u0027'", 
		"'agrupar'", "'and'", "'asc'", "'avg'", "'count'", "'cruz'", "'desc'", 
		"'diferencia'", "'division'", "'inter'", "'max'", "'min'", "'or'", "'ordenar'", 
		"'proyectar'", "'renombrar'", "'reunion'", "'reunion_ext_der'", "'reunion_ext_full'", 
		"'reunion_ext_izq'", "'reunion_natural'", "'seleccionar'", "'sum'", "'union'"
	};
	public static final int EOF=-1;
	public static final int T__7=7;
	public static final int T__8=8;
	public static final int T__9=9;
	public static final int T__10=10;
	public static final int T__11=11;
	public static final int T__12=12;
	public static final int T__13=13;
	public static final int T__14=14;
	public static final int T__15=15;
	public static final int T__16=16;
	public static final int T__17=17;
	public static final int T__18=18;
	public static final int T__19=19;
	public static final int T__20=20;
	public static final int T__21=21;
	public static final int T__22=22;
	public static final int T__23=23;
	public static final int T__24=24;
	public static final int T__25=25;
	public static final int T__26=26;
	public static final int T__27=27;
	public static final int T__28=28;
	public static final int T__29=29;
	public static final int T__30=30;
	public static final int T__31=31;
	public static final int T__32=32;
	public static final int T__33=33;
	public static final int T__34=34;
	public static final int T__35=35;
	public static final int T__36=36;
	public static final int T__37=37;
	public static final int T__38=38;
	public static final int T__39=39;
	public static final int T__40=40;
	public static final int T__41=41;
	public static final int T__42=42;
	public static final int T__43=43;
	public static final int T__44=44;
	public static final int T__45=45;
	public static final int T__46=46;
	public static final int T__47=47;
	public static final int T__48=48;
	public static final int T__49=49;
	public static final int T__50=50;
	public static final int T__51=51;
	public static final int T__52=52;
	public static final int T__53=53;
	public static final int T__54=54;
	public static final int T__55=55;
	public static final int T__56=56;
	public static final int T__57=57;
	public static final int T__58=58;
	public static final int T__59=59;
	public static final int T__60=60;
	public static final int T__61=61;
	public static final int T__62=62;
	public static final int T__63=63;
	public static final int T__64=64;
	public static final int T__65=65;
	public static final int CAD=4;
	public static final int NUM=5;
	public static final int WS=6;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public AlgebraRelacionalParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public AlgebraRelacionalParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return AlgebraRelacionalParser.tokenNames; }
	@Override public String getGrammarFileName() { return "C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g"; }



	// $ANTLR start "st"
	// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:3:1: st : ( asg | con ) ;
	public final void st() throws RecognitionException {
		try {
			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:3:4: ( ( asg | con ) )
			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:3:6: ( asg | con )
			{
			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:3:6: ( asg | con )
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0==CAD) ) {
				int LA1_1 = input.LA(2);
				if ( (LA1_1==13) ) {
					alt1=1;
				}
				else if ( (LA1_1==10||LA1_1==19||(LA1_1 >= 23 && LA1_1 <= 26)||(LA1_1 >= 34 && LA1_1 <= 37)||LA1_1==40||LA1_1==42||LA1_1==47||(LA1_1 >= 49 && LA1_1 <= 51)||(LA1_1 >= 59 && LA1_1 <= 62)||LA1_1==65) ) {
					alt1=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 1, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA1_0==8||(LA1_0 >= 21 && LA1_0 <= 22)||(LA1_0 >= 27 && LA1_0 <= 28)||(LA1_0 >= 30 && LA1_0 <= 32)||(LA1_0 >= 38 && LA1_0 <= 39)||(LA1_0 >= 45 && LA1_0 <= 46)||(LA1_0 >= 52 && LA1_0 <= 53)||(LA1_0 >= 55 && LA1_0 <= 57)||(LA1_0 >= 63 && LA1_0 <= 64)) ) {
				alt1=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}

			switch (alt1) {
				case 1 :
					// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:3:8: asg
					{
					pushFollow(FOLLOW_asg_in_st12);
					asg();
					state._fsp--;

					}
					break;
				case 2 :
					// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:3:14: con
					{
					pushFollow(FOLLOW_con_in_st16);
					con();
					state._fsp--;

					}
					break;

			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "st"



	// $ANTLR start "asg"
	// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:4:1: asg : rel ':=' con ;
	public final void asg() throws RecognitionException {
		try {
			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:4:5: ( rel ':=' con )
			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:4:7: rel ':=' con
			{
			pushFollow(FOLLOW_rel_in_asg25);
			rel();
			state._fsp--;

			match(input,13,FOLLOW_13_in_asg27); 
			pushFollow(FOLLOW_con_in_asg29);
			con();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "asg"



	// $ANTLR start "con"
	// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:5:1: con : ( bin | select | proy | renom1 | renom2 | renom3 | join | groupby | orderby | agregation ) ;
	public final void con() throws RecognitionException {
		try {
			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:5:5: ( ( bin | select | proy | renom1 | renom2 | renom3 | join | groupby | orderby | agregation ) )
			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:5:7: ( bin | select | proy | renom1 | renom2 | renom3 | join | groupby | orderby | agregation )
			{
			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:5:7: ( bin | select | proy | renom1 | renom2 | renom3 | join | groupby | orderby | agregation )
			int alt2=10;
			switch ( input.LA(1) ) {
			case CAD:
				{
				int LA2_1 = input.LA(2);
				if ( ((LA2_1 >= 23 && LA2_1 <= 26)||(LA2_1 >= 34 && LA2_1 <= 37)||LA2_1==40||LA2_1==47||(LA2_1 >= 49 && LA2_1 <= 51)||(LA2_1 >= 59 && LA2_1 <= 62)||LA2_1==65) ) {
					alt2=1;
				}
				else if ( (LA2_1==10||LA2_1==19||LA2_1==42) ) {
					alt2=8;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 2, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case 38:
			case 63:
				{
				alt2=2;
				}
				break;
			case 31:
			case 56:
				{
				alt2=3;
				}
				break;
			case 32:
			case 57:
				{
				int LA2_4 = input.LA(2);
				if ( (LA2_4==8) ) {
					alt2=6;
				}
				else if ( (LA2_4==CAD) ) {
					int LA2_11 = input.LA(3);
					if ( (LA2_11==8) ) {
						int LA2_12 = input.LA(4);
						if ( (LA2_12==CAD) ) {
							int LA2_13 = input.LA(5);
							if ( (LA2_13==10) ) {
								alt2=4;
							}
							else if ( (LA2_13==9) ) {
								int LA2_15 = input.LA(6);
								if ( (LA2_15==8) ) {
									alt2=4;
								}
								else if ( (LA2_15==EOF) ) {
									alt2=5;
								}

								else {
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 6 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 2, 15, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}

							}

							else {
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 2, 13, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

						}

						else {
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 2, 12, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 2, 11, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 2, 4, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case 8:
				{
				alt2=7;
				}
				break;
			case 30:
			case 55:
				{
				alt2=9;
				}
				break;
			case 21:
			case 22:
			case 27:
			case 28:
			case 39:
			case 45:
			case 46:
			case 52:
			case 53:
			case 64:
				{
				alt2=10;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}
			switch (alt2) {
				case 1 :
					// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:5:9: bin
					{
					pushFollow(FOLLOW_bin_in_con38);
					bin();
					state._fsp--;

					}
					break;
				case 2 :
					// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:5:15: select
					{
					pushFollow(FOLLOW_select_in_con42);
					select();
					state._fsp--;

					}
					break;
				case 3 :
					// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:5:24: proy
					{
					pushFollow(FOLLOW_proy_in_con46);
					proy();
					state._fsp--;

					}
					break;
				case 4 :
					// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:5:31: renom1
					{
					pushFollow(FOLLOW_renom1_in_con50);
					renom1();
					state._fsp--;

					}
					break;
				case 5 :
					// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:5:40: renom2
					{
					pushFollow(FOLLOW_renom2_in_con54);
					renom2();
					state._fsp--;

					}
					break;
				case 6 :
					// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:5:49: renom3
					{
					pushFollow(FOLLOW_renom3_in_con58);
					renom3();
					state._fsp--;

					}
					break;
				case 7 :
					// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:5:58: join
					{
					pushFollow(FOLLOW_join_in_con62);
					join();
					state._fsp--;

					}
					break;
				case 8 :
					// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:5:65: groupby
					{
					pushFollow(FOLLOW_groupby_in_con66);
					groupby();
					state._fsp--;

					}
					break;
				case 9 :
					// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:5:75: orderby
					{
					pushFollow(FOLLOW_orderby_in_con70);
					orderby();
					state._fsp--;

					}
					break;
				case 10 :
					// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:5:85: agregation
					{
					pushFollow(FOLLOW_agregation_in_con74);
					agregation();
					state._fsp--;

					}
					break;

			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "con"



	// $ANTLR start "bin"
	// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:7:1: bin : ( rel ( 'UNION' | 'union' ) rel | rel ( 'INTER' | 'inter' ) rel | rel ( 'DIFERENCIA' | 'diferencia' ) rel | rel ( 'CRUZ' | 'cruz' ) rel | rel ( 'REUNION_NATURAL' | 'reunion_natural' ) rel | rel ( 'division' | 'DIVISION' ) rel | rel ( 'reunion_ext_izq' | 'REUNION_EXT_IZQ' ) rel | rel ( 'reunion_ext_der' | 'REUNION_EXT_DER' ) rel | rel ( 'reunion_ext_full' | 'REUNION_EXT_FULL' ) rel );
	public final void bin() throws RecognitionException {
		try {
			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:7:5: ( rel ( 'UNION' | 'union' ) rel | rel ( 'INTER' | 'inter' ) rel | rel ( 'DIFERENCIA' | 'diferencia' ) rel | rel ( 'CRUZ' | 'cruz' ) rel | rel ( 'REUNION_NATURAL' | 'reunion_natural' ) rel | rel ( 'division' | 'DIVISION' ) rel | rel ( 'reunion_ext_izq' | 'REUNION_EXT_IZQ' ) rel | rel ( 'reunion_ext_der' | 'REUNION_EXT_DER' ) rel | rel ( 'reunion_ext_full' | 'REUNION_EXT_FULL' ) rel )
			int alt3=9;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==CAD) ) {
				switch ( input.LA(2) ) {
				case 40:
				case 65:
					{
					alt3=1;
					}
					break;
				case 26:
				case 51:
					{
					alt3=2;
					}
					break;
				case 24:
				case 49:
					{
					alt3=3;
					}
					break;
				case 23:
				case 47:
					{
					alt3=4;
					}
					break;
				case 37:
				case 62:
					{
					alt3=5;
					}
					break;
				case 25:
				case 50:
					{
					alt3=6;
					}
					break;
				case 36:
				case 61:
					{
					alt3=7;
					}
					break;
				case 34:
				case 59:
					{
					alt3=8;
					}
					break;
				case 35:
				case 60:
					{
					alt3=9;
					}
					break;
				default:
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 3, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:7:7: rel ( 'UNION' | 'union' ) rel
					{
					pushFollow(FOLLOW_rel_in_bin84);
					rel();
					state._fsp--;

					if ( input.LA(1)==40||input.LA(1)==65 ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_rel_in_bin92);
					rel();
					state._fsp--;

					}
					break;
				case 2 :
					// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:8:3: rel ( 'INTER' | 'inter' ) rel
					{
					pushFollow(FOLLOW_rel_in_bin96);
					rel();
					state._fsp--;

					if ( input.LA(1)==26||input.LA(1)==51 ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_rel_in_bin104);
					rel();
					state._fsp--;

					}
					break;
				case 3 :
					// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:9:3: rel ( 'DIFERENCIA' | 'diferencia' ) rel
					{
					pushFollow(FOLLOW_rel_in_bin108);
					rel();
					state._fsp--;

					if ( input.LA(1)==24||input.LA(1)==49 ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_rel_in_bin116);
					rel();
					state._fsp--;

					}
					break;
				case 4 :
					// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:10:3: rel ( 'CRUZ' | 'cruz' ) rel
					{
					pushFollow(FOLLOW_rel_in_bin120);
					rel();
					state._fsp--;

					if ( input.LA(1)==23||input.LA(1)==47 ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_rel_in_bin128);
					rel();
					state._fsp--;

					}
					break;
				case 5 :
					// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:11:3: rel ( 'REUNION_NATURAL' | 'reunion_natural' ) rel
					{
					pushFollow(FOLLOW_rel_in_bin132);
					rel();
					state._fsp--;

					if ( input.LA(1)==37||input.LA(1)==62 ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_rel_in_bin140);
					rel();
					state._fsp--;

					}
					break;
				case 6 :
					// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:12:3: rel ( 'division' | 'DIVISION' ) rel
					{
					pushFollow(FOLLOW_rel_in_bin144);
					rel();
					state._fsp--;

					if ( input.LA(1)==25||input.LA(1)==50 ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_rel_in_bin152);
					rel();
					state._fsp--;

					}
					break;
				case 7 :
					// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:13:3: rel ( 'reunion_ext_izq' | 'REUNION_EXT_IZQ' ) rel
					{
					pushFollow(FOLLOW_rel_in_bin156);
					rel();
					state._fsp--;

					if ( input.LA(1)==36||input.LA(1)==61 ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_rel_in_bin164);
					rel();
					state._fsp--;

					}
					break;
				case 8 :
					// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:14:3: rel ( 'reunion_ext_der' | 'REUNION_EXT_DER' ) rel
					{
					pushFollow(FOLLOW_rel_in_bin168);
					rel();
					state._fsp--;

					if ( input.LA(1)==34||input.LA(1)==59 ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_rel_in_bin176);
					rel();
					state._fsp--;

					}
					break;
				case 9 :
					// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:15:3: rel ( 'reunion_ext_full' | 'REUNION_EXT_FULL' ) rel
					{
					pushFollow(FOLLOW_rel_in_bin180);
					rel();
					state._fsp--;

					if ( input.LA(1)==35||input.LA(1)==60 ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_rel_in_bin188);
					rel();
					state._fsp--;

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "bin"



	// $ANTLR start "select"
	// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:17:1: select : ( 'seleccionar' | 'SELECCIONAR' ) '(' conds1 ')' '(' rel ')' ;
	public final void select() throws RecognitionException {
		try {
			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:17:8: ( ( 'seleccionar' | 'SELECCIONAR' ) '(' conds1 ')' '(' rel ')' )
			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:17:10: ( 'seleccionar' | 'SELECCIONAR' ) '(' conds1 ')' '(' rel ')'
			{
			if ( input.LA(1)==38||input.LA(1)==63 ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			match(input,8,FOLLOW_8_in_select201); 
			pushFollow(FOLLOW_conds1_in_select202);
			conds1();
			state._fsp--;

			match(input,9,FOLLOW_9_in_select203); 
			match(input,8,FOLLOW_8_in_select204); 
			pushFollow(FOLLOW_rel_in_select205);
			rel();
			state._fsp--;

			match(input,9,FOLLOW_9_in_select206); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "select"



	// $ANTLR start "proy"
	// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:18:1: proy : ( 'proyectar' | 'PROYECTAR' ) '(' atts ')' '(' rel ')' ;
	public final void proy() throws RecognitionException {
		try {
			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:18:6: ( ( 'proyectar' | 'PROYECTAR' ) '(' atts ')' '(' rel ')' )
			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:18:8: ( 'proyectar' | 'PROYECTAR' ) '(' atts ')' '(' rel ')'
			{
			if ( input.LA(1)==31||input.LA(1)==56 ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			match(input,8,FOLLOW_8_in_proy218); 
			pushFollow(FOLLOW_atts_in_proy219);
			atts();
			state._fsp--;

			match(input,9,FOLLOW_9_in_proy220); 
			match(input,8,FOLLOW_8_in_proy221); 
			pushFollow(FOLLOW_rel_in_proy222);
			rel();
			state._fsp--;

			match(input,9,FOLLOW_9_in_proy223); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "proy"



	// $ANTLR start "renom1"
	// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:19:1: renom1 : ( 'renombrar' | 'RENOMBRAR' ) rel '(' atts ')' '(' rel ')' ;
	public final void renom1() throws RecognitionException {
		try {
			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:19:8: ( ( 'renombrar' | 'RENOMBRAR' ) rel '(' atts ')' '(' rel ')' )
			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:19:10: ( 'renombrar' | 'RENOMBRAR' ) rel '(' atts ')' '(' rel ')'
			{
			if ( input.LA(1)==32||input.LA(1)==57 ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			pushFollow(FOLLOW_rel_in_renom1236);
			rel();
			state._fsp--;

			match(input,8,FOLLOW_8_in_renom1238); 
			pushFollow(FOLLOW_atts_in_renom1239);
			atts();
			state._fsp--;

			match(input,9,FOLLOW_9_in_renom1240); 
			match(input,8,FOLLOW_8_in_renom1241); 
			pushFollow(FOLLOW_rel_in_renom1242);
			rel();
			state._fsp--;

			match(input,9,FOLLOW_9_in_renom1243); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "renom1"



	// $ANTLR start "renom2"
	// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:20:1: renom2 : ( 'renombrar' | 'RENOMBRAR' ) rel '(' rel ')' ;
	public final void renom2() throws RecognitionException {
		try {
			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:20:8: ( ( 'renombrar' | 'RENOMBRAR' ) rel '(' rel ')' )
			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:20:10: ( 'renombrar' | 'RENOMBRAR' ) rel '(' rel ')'
			{
			if ( input.LA(1)==32||input.LA(1)==57 ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			pushFollow(FOLLOW_rel_in_renom2256);
			rel();
			state._fsp--;

			match(input,8,FOLLOW_8_in_renom2258); 
			pushFollow(FOLLOW_rel_in_renom2259);
			rel();
			state._fsp--;

			match(input,9,FOLLOW_9_in_renom2260); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "renom2"



	// $ANTLR start "renom3"
	// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:21:1: renom3 : ( 'renombrar' | 'RENOMBRAR' ) '(' atts ')' '(' rel ')' ;
	public final void renom3() throws RecognitionException {
		try {
			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:21:8: ( ( 'renombrar' | 'RENOMBRAR' ) '(' atts ')' '(' rel ')' )
			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:21:10: ( 'renombrar' | 'RENOMBRAR' ) '(' atts ')' '(' rel ')'
			{
			if ( input.LA(1)==32||input.LA(1)==57 ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			match(input,8,FOLLOW_8_in_renom3272); 
			pushFollow(FOLLOW_atts_in_renom3273);
			atts();
			state._fsp--;

			match(input,9,FOLLOW_9_in_renom3274); 
			match(input,8,FOLLOW_8_in_renom3275); 
			pushFollow(FOLLOW_rel_in_renom3276);
			rel();
			state._fsp--;

			match(input,9,FOLLOW_9_in_renom3277); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "renom3"



	// $ANTLR start "join"
	// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:22:1: join : '(' rel ')' ( 'reunion' | 'REUNION' ) '(' conds2 ')' '(' rel ')' ;
	public final void join() throws RecognitionException {
		try {
			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:22:6: ( '(' rel ')' ( 'reunion' | 'REUNION' ) '(' conds2 ')' '(' rel ')' )
			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:22:8: '(' rel ')' ( 'reunion' | 'REUNION' ) '(' conds2 ')' '(' rel ')'
			{
			match(input,8,FOLLOW_8_in_join284); 
			pushFollow(FOLLOW_rel_in_join285);
			rel();
			state._fsp--;

			match(input,9,FOLLOW_9_in_join286); 
			if ( input.LA(1)==33||input.LA(1)==58 ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			match(input,8,FOLLOW_8_in_join292); 
			pushFollow(FOLLOW_conds2_in_join293);
			conds2();
			state._fsp--;

			match(input,9,FOLLOW_9_in_join294); 
			match(input,8,FOLLOW_8_in_join295); 
			pushFollow(FOLLOW_rel_in_join296);
			rel();
			state._fsp--;

			match(input,9,FOLLOW_9_in_join297); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "join"



	// $ANTLR start "groupby"
	// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:23:1: groupby : atts ( 'agrupar' | 'AGRUPAR' ) fagregas '(' rel ')' ;
	public final void groupby() throws RecognitionException {
		try {
			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:23:9: ( atts ( 'agrupar' | 'AGRUPAR' ) fagregas '(' rel ')' )
			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:23:11: atts ( 'agrupar' | 'AGRUPAR' ) fagregas '(' rel ')'
			{
			pushFollow(FOLLOW_atts_in_groupby304);
			atts();
			state._fsp--;

			if ( input.LA(1)==19||input.LA(1)==42 ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			pushFollow(FOLLOW_fagregas_in_groupby313);
			fagregas();
			state._fsp--;

			match(input,8,FOLLOW_8_in_groupby315); 
			pushFollow(FOLLOW_rel_in_groupby316);
			rel();
			state._fsp--;

			match(input,9,FOLLOW_9_in_groupby317); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "groupby"



	// $ANTLR start "orderby"
	// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:24:1: orderby : ( 'ordenar' | 'ORDENAR' ) orders '(' rel ')' ;
	public final void orderby() throws RecognitionException {
		try {
			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:24:9: ( ( 'ordenar' | 'ORDENAR' ) orders '(' rel ')' )
			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:24:11: ( 'ordenar' | 'ORDENAR' ) orders '(' rel ')'
			{
			if ( input.LA(1)==30||input.LA(1)==55 ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			pushFollow(FOLLOW_orders_in_orderby334);
			orders();
			state._fsp--;

			match(input,8,FOLLOW_8_in_orderby336); 
			pushFollow(FOLLOW_rel_in_orderby337);
			rel();
			state._fsp--;

			match(input,9,FOLLOW_9_in_orderby338); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "orderby"



	// $ANTLR start "agregation"
	// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:25:1: agregation : fagrega ( att '(' rel ')' ) ;
	public final void agregation() throws RecognitionException {
		try {
			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:25:12: ( fagrega ( att '(' rel ')' ) )
			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:25:14: fagrega ( att '(' rel ')' )
			{
			pushFollow(FOLLOW_fagrega_in_agregation346);
			fagrega();
			state._fsp--;

			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:25:22: ( att '(' rel ')' )
			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:25:24: att '(' rel ')'
			{
			pushFollow(FOLLOW_att_in_agregation350);
			att();
			state._fsp--;

			match(input,8,FOLLOW_8_in_agregation352); 
			pushFollow(FOLLOW_rel_in_agregation353);
			rel();
			state._fsp--;

			match(input,9,FOLLOW_9_in_agregation354); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "agregation"



	// $ANTLR start "atts"
	// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:28:1: atts : att ( ',' att )* ;
	public final void atts() throws RecognitionException {
		try {
			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:28:6: ( att ( ',' att )* )
			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:28:8: att ( ',' att )*
			{
			pushFollow(FOLLOW_att_in_atts366);
			att();
			state._fsp--;

			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:28:12: ( ',' att )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==10) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:28:13: ',' att
					{
					match(input,10,FOLLOW_10_in_atts369); 
					pushFollow(FOLLOW_att_in_atts371);
					att();
					state._fsp--;

					}
					break;

				default :
					break loop4;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "atts"



	// $ANTLR start "conds1"
	// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:29:1: conds1 : cond1 ( ( 'and' | 'or' | 'AND' | 'OR' ) cond1 )* ;
	public final void conds1() throws RecognitionException {
		try {
			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:29:8: ( cond1 ( ( 'and' | 'or' | 'AND' | 'OR' ) cond1 )* )
			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:29:10: cond1 ( ( 'and' | 'or' | 'AND' | 'OR' ) cond1 )*
			{
			pushFollow(FOLLOW_cond1_in_conds1380);
			cond1();
			state._fsp--;

			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:29:16: ( ( 'and' | 'or' | 'AND' | 'OR' ) cond1 )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==20||LA5_0==29||LA5_0==43||LA5_0==54) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:29:17: ( 'and' | 'or' | 'AND' | 'OR' ) cond1
					{
					if ( input.LA(1)==20||input.LA(1)==29||input.LA(1)==43||input.LA(1)==54 ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_cond1_in_conds1401);
					cond1();
					state._fsp--;

					}
					break;

				default :
					break loop5;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "conds1"



	// $ANTLR start "conds2"
	// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:30:1: conds2 : cond2 ( ( 'and' | 'or' | 'AND' | 'OR' ) cond2 )* ;
	public final void conds2() throws RecognitionException {
		try {
			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:30:8: ( cond2 ( ( 'and' | 'or' | 'AND' | 'OR' ) cond2 )* )
			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:30:10: cond2 ( ( 'and' | 'or' | 'AND' | 'OR' ) cond2 )*
			{
			pushFollow(FOLLOW_cond2_in_conds2410);
			cond2();
			state._fsp--;

			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:30:16: ( ( 'and' | 'or' | 'AND' | 'OR' ) cond2 )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==20||LA6_0==29||LA6_0==43||LA6_0==54) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:30:17: ( 'and' | 'or' | 'AND' | 'OR' ) cond2
					{
					if ( input.LA(1)==20||input.LA(1)==29||input.LA(1)==43||input.LA(1)==54 ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_cond2_in_conds2431);
					cond2();
					state._fsp--;

					}
					break;

				default :
					break loop6;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "conds2"



	// $ANTLR start "cond1"
	// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:31:1: cond1 : ( con1 ) ;
	public final void cond1() throws RecognitionException {
		try {
			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:31:7: ( ( con1 ) )
			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:31:9: ( con1 )
			{
			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:31:9: ( con1 )
			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:31:11: con1
			{
			pushFollow(FOLLOW_con1_in_cond1442);
			con1();
			state._fsp--;

			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "cond1"



	// $ANTLR start "cond2"
	// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:32:1: cond2 : ( con2 | con3 ) ;
	public final void cond2() throws RecognitionException {
		try {
			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:32:7: ( ( con2 | con3 ) )
			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:32:9: ( con2 | con3 )
			{
			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:32:9: ( con2 | con3 )
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==CAD) ) {
				int LA7_1 = input.LA(2);
				if ( (LA7_1==12) ) {
					int LA7_2 = input.LA(3);
					if ( (LA7_2==CAD) ) {
						int LA7_3 = input.LA(4);
						if ( (LA7_3==7||(LA7_3 >= 14 && LA7_3 <= 18)) ) {
							int LA7_4 = input.LA(5);
							if ( (LA7_4==CAD) ) {
								alt7=1;
							}
							else if ( (LA7_4==NUM||LA7_4==11||LA7_4==41) ) {
								alt7=2;
							}

							else {
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 7, 4, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

						}

						else {
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 7, 3, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 7, 2, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 7, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}

			switch (alt7) {
				case 1 :
					// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:32:11: con2
					{
					pushFollow(FOLLOW_con2_in_cond2453);
					con2();
					state._fsp--;

					}
					break;
				case 2 :
					// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:32:17: con3
					{
					pushFollow(FOLLOW_con3_in_cond2456);
					con3();
					state._fsp--;

					}
					break;

			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "cond2"



	// $ANTLR start "orders"
	// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:33:1: orders : att '(' order ')' ( ',' att '(' order ')' )* ;
	public final void orders() throws RecognitionException {
		try {
			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:33:8: ( att '(' order ')' ( ',' att '(' order ')' )* )
			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:33:10: att '(' order ')' ( ',' att '(' order ')' )*
			{
			pushFollow(FOLLOW_att_in_orders465);
			att();
			state._fsp--;

			match(input,8,FOLLOW_8_in_orders467); 
			pushFollow(FOLLOW_order_in_orders468);
			order();
			state._fsp--;

			match(input,9,FOLLOW_9_in_orders469); 
			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:33:26: ( ',' att '(' order ')' )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==10) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:33:27: ',' att '(' order ')'
					{
					match(input,10,FOLLOW_10_in_orders472); 
					pushFollow(FOLLOW_att_in_orders474);
					att();
					state._fsp--;

					match(input,8,FOLLOW_8_in_orders476); 
					pushFollow(FOLLOW_order_in_orders477);
					order();
					state._fsp--;

					match(input,9,FOLLOW_9_in_orders478); 
					}
					break;

				default :
					break loop8;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "orders"



	// $ANTLR start "order"
	// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:34:1: order : ( 'asc' | 'desc' ) ;
	public final void order() throws RecognitionException {
		try {
			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:34:7: ( ( 'asc' | 'desc' ) )
			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:
			{
			if ( input.LA(1)==44||input.LA(1)==48 ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "order"



	// $ANTLR start "fagregas"
	// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:35:1: fagregas : fagrega '(' att ')' ( ',' fagrega '(' att ')' )* ;
	public final void fagregas() throws RecognitionException {
		try {
			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:35:9: ( fagrega '(' att ')' ( ',' fagrega '(' att ')' )* )
			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:35:11: fagrega '(' att ')' ( ',' fagrega '(' att ')' )*
			{
			pushFollow(FOLLOW_fagrega_in_fagregas502);
			fagrega();
			state._fsp--;

			match(input,8,FOLLOW_8_in_fagregas504); 
			pushFollow(FOLLOW_att_in_fagregas505);
			att();
			state._fsp--;

			match(input,9,FOLLOW_9_in_fagregas506); 
			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:35:29: ( ',' fagrega '(' att ')' )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==10) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:35:30: ',' fagrega '(' att ')'
					{
					match(input,10,FOLLOW_10_in_fagregas509); 
					pushFollow(FOLLOW_fagrega_in_fagregas511);
					fagrega();
					state._fsp--;

					match(input,8,FOLLOW_8_in_fagregas513); 
					pushFollow(FOLLOW_att_in_fagregas514);
					att();
					state._fsp--;

					match(input,9,FOLLOW_9_in_fagregas515); 
					}
					break;

				default :
					break loop9;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "fagregas"



	// $ANTLR start "fagrega"
	// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:36:1: fagrega : ( 'sum' | 'SUM' | 'avg' | 'AVG' | 'count' | 'COUNT' | 'min' | 'MIN' | 'max' | 'MAX' ) ;
	public final void fagrega() throws RecognitionException {
		try {
			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:36:9: ( ( 'sum' | 'SUM' | 'avg' | 'AVG' | 'count' | 'COUNT' | 'min' | 'MIN' | 'max' | 'MAX' ) )
			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:
			{
			if ( (input.LA(1) >= 21 && input.LA(1) <= 22)||(input.LA(1) >= 27 && input.LA(1) <= 28)||input.LA(1)==39||(input.LA(1) >= 45 && input.LA(1) <= 46)||(input.LA(1) >= 52 && input.LA(1) <= 53)||input.LA(1)==64 ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "fagrega"



	// $ANTLR start "con1"
	// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:37:1: con1 : att ( '=' | '<' | '<=' | '>' | '>= ' | '!=' ) cons ;
	public final void con1() throws RecognitionException {
		try {
			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:37:6: ( att ( '=' | '<' | '<=' | '>' | '>= ' | '!=' ) cons )
			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:37:8: att ( '=' | '<' | '<=' | '>' | '>= ' | '!=' ) cons
			{
			pushFollow(FOLLOW_att_in_con1571);
			att();
			state._fsp--;

			if ( input.LA(1)==7||(input.LA(1) >= 14 && input.LA(1) <= 18) ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			pushFollow(FOLLOW_cons_in_con1597);
			cons();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "con1"



	// $ANTLR start "con2"
	// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:38:1: con2 : rel '.' att ( '=' | '<' | '<=' | '>' | '>= ' | '!=' ) rel '.' att ;
	public final void con2() throws RecognitionException {
		try {
			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:38:6: ( rel '.' att ( '=' | '<' | '<=' | '>' | '>= ' | '!=' ) rel '.' att )
			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:38:8: rel '.' att ( '=' | '<' | '<=' | '>' | '>= ' | '!=' ) rel '.' att
			{
			pushFollow(FOLLOW_rel_in_con2604);
			rel();
			state._fsp--;

			match(input,12,FOLLOW_12_in_con2605); 
			pushFollow(FOLLOW_att_in_con2606);
			att();
			state._fsp--;

			if ( input.LA(1)==7||(input.LA(1) >= 14 && input.LA(1) <= 18) ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			pushFollow(FOLLOW_rel_in_con2632);
			rel();
			state._fsp--;

			match(input,12,FOLLOW_12_in_con2633); 
			pushFollow(FOLLOW_att_in_con2634);
			att();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "con2"



	// $ANTLR start "con3"
	// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:39:1: con3 : rel '.' att ( '=' | '<' | '<=' | '>' | '>= ' | '!=' ) cons ;
	public final void con3() throws RecognitionException {
		try {
			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:39:6: ( rel '.' att ( '=' | '<' | '<=' | '>' | '>= ' | '!=' ) cons )
			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:39:8: rel '.' att ( '=' | '<' | '<=' | '>' | '>= ' | '!=' ) cons
			{
			pushFollow(FOLLOW_rel_in_con3641);
			rel();
			state._fsp--;

			match(input,12,FOLLOW_12_in_con3642); 
			pushFollow(FOLLOW_att_in_con3643);
			att();
			state._fsp--;

			if ( input.LA(1)==7||(input.LA(1) >= 14 && input.LA(1) <= 18) ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			pushFollow(FOLLOW_cons_in_con3669);
			cons();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "con3"



	// $ANTLR start "cons"
	// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:40:1: cons : ( num | cad ) ;
	public final void cons() throws RecognitionException {
		try {
			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:40:6: ( ( num | cad ) )
			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:40:8: ( num | cad )
			{
			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:40:8: ( num | cad )
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==NUM||LA10_0==11) ) {
				alt10=1;
			}
			else if ( (LA10_0==41) ) {
				alt10=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}

			switch (alt10) {
				case 1 :
					// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:40:10: num
					{
					pushFollow(FOLLOW_num_in_cons678);
					num();
					state._fsp--;

					}
					break;
				case 2 :
					// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:40:16: cad
					{
					pushFollow(FOLLOW_cad_in_cons682);
					cad();
					state._fsp--;

					}
					break;

			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "cons"



	// $ANTLR start "num"
	// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:41:1: num : ( '-' )? ( NUM )+ ( '.' ( NUM )+ )? ;
	public final void num() throws RecognitionException {
		try {
			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:41:5: ( ( '-' )? ( NUM )+ ( '.' ( NUM )+ )? )
			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:41:7: ( '-' )? ( NUM )+ ( '.' ( NUM )+ )?
			{
			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:41:7: ( '-' )?
			int alt11=2;
			int LA11_0 = input.LA(1);
			if ( (LA11_0==11) ) {
				alt11=1;
			}
			switch (alt11) {
				case 1 :
					// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:41:8: '-'
					{
					match(input,11,FOLLOW_11_in_num692); 
					}
					break;

			}

			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:41:13: ( NUM )+
			int cnt12=0;
			loop12:
			while (true) {
				int alt12=2;
				int LA12_0 = input.LA(1);
				if ( (LA12_0==NUM) ) {
					alt12=1;
				}

				switch (alt12) {
				case 1 :
					// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:41:14: NUM
					{
					match(input,NUM,FOLLOW_NUM_in_num696); 
					}
					break;

				default :
					if ( cnt12 >= 1 ) break loop12;
					EarlyExitException eee = new EarlyExitException(12, input);
					throw eee;
				}
				cnt12++;
			}

			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:41:19: ( '.' ( NUM )+ )?
			int alt14=2;
			int LA14_0 = input.LA(1);
			if ( (LA14_0==12) ) {
				alt14=1;
			}
			switch (alt14) {
				case 1 :
					// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:41:20: '.' ( NUM )+
					{
					match(input,12,FOLLOW_12_in_num700); 
					// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:41:23: ( NUM )+
					int cnt13=0;
					loop13:
					while (true) {
						int alt13=2;
						int LA13_0 = input.LA(1);
						if ( (LA13_0==NUM) ) {
							alt13=1;
						}

						switch (alt13) {
						case 1 :
							// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:41:24: NUM
							{
							match(input,NUM,FOLLOW_NUM_in_num702); 
							}
							break;

						default :
							if ( cnt13 >= 1 ) break loop13;
							EarlyExitException eee = new EarlyExitException(13, input);
							throw eee;
						}
						cnt13++;
					}

					}
					break;

			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "num"



	// $ANTLR start "cad"
	// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:42:1: cad : '\\u0027' CAD '\\u0027' ;
	public final void cad() throws RecognitionException {
		try {
			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:42:5: ( '\\u0027' CAD '\\u0027' )
			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:42:7: '\\u0027' CAD '\\u0027'
			{
			match(input,41,FOLLOW_41_in_cad713); 
			match(input,CAD,FOLLOW_CAD_in_cad714); 
			match(input,41,FOLLOW_41_in_cad715); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "cad"



	// $ANTLR start "att"
	// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:43:1: att : CAD ;
	public final void att() throws RecognitionException {
		try {
			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:43:5: ( CAD )
			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:43:7: CAD
			{
			match(input,CAD,FOLLOW_CAD_in_att722); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "att"



	// $ANTLR start "rel"
	// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:44:1: rel : CAD ;
	public final void rel() throws RecognitionException {
		try {
			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:44:5: ( CAD )
			// C:\\Users\\yianv\\Desktop\\gramatica\\AlgebraRelacional.g:44:7: CAD
			{
			match(input,CAD,FOLLOW_CAD_in_rel729); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "rel"

	// Delegated rules



	public static final BitSet FOLLOW_asg_in_st12 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_con_in_st16 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rel_in_asg25 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_asg27 = new BitSet(new long[]{0x83B060C1D8600110L,0x0000000000000001L});
	public static final BitSet FOLLOW_con_in_asg29 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_bin_in_con38 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_select_in_con42 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_proy_in_con46 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_renom1_in_con50 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_renom2_in_con54 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_renom3_in_con58 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_join_in_con62 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_groupby_in_con66 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_orderby_in_con70 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_agregation_in_con74 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rel_in_bin84 = new BitSet(new long[]{0x0000010000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_set_in_bin86 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_rel_in_bin92 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rel_in_bin96 = new BitSet(new long[]{0x0008000004000000L});
	public static final BitSet FOLLOW_set_in_bin98 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_rel_in_bin104 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rel_in_bin108 = new BitSet(new long[]{0x0002000001000000L});
	public static final BitSet FOLLOW_set_in_bin110 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_rel_in_bin116 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rel_in_bin120 = new BitSet(new long[]{0x0000800000800000L});
	public static final BitSet FOLLOW_set_in_bin122 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_rel_in_bin128 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rel_in_bin132 = new BitSet(new long[]{0x4000002000000000L});
	public static final BitSet FOLLOW_set_in_bin134 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_rel_in_bin140 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rel_in_bin144 = new BitSet(new long[]{0x0004000002000000L});
	public static final BitSet FOLLOW_set_in_bin146 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_rel_in_bin152 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rel_in_bin156 = new BitSet(new long[]{0x2000001000000000L});
	public static final BitSet FOLLOW_set_in_bin158 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_rel_in_bin164 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rel_in_bin168 = new BitSet(new long[]{0x0800000400000000L});
	public static final BitSet FOLLOW_set_in_bin170 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_rel_in_bin176 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rel_in_bin180 = new BitSet(new long[]{0x1000000800000000L});
	public static final BitSet FOLLOW_set_in_bin182 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_rel_in_bin188 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_in_select196 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_8_in_select201 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_conds1_in_select202 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_select203 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_8_in_select204 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_rel_in_select205 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_select206 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_in_proy213 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_8_in_proy218 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_atts_in_proy219 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_proy220 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_8_in_proy221 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_rel_in_proy222 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_proy223 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_in_renom1230 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_rel_in_renom1236 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_8_in_renom1238 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_atts_in_renom1239 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_renom1240 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_8_in_renom1241 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_rel_in_renom1242 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_renom1243 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_in_renom2250 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_rel_in_renom2256 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_8_in_renom2258 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_rel_in_renom2259 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_renom2260 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_in_renom3267 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_8_in_renom3272 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_atts_in_renom3273 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_renom3274 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_8_in_renom3275 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_rel_in_renom3276 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_renom3277 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_8_in_join284 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_rel_in_join285 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_join286 = new BitSet(new long[]{0x0400000200000000L});
	public static final BitSet FOLLOW_set_in_join287 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_8_in_join292 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_conds2_in_join293 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_join294 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_8_in_join295 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_rel_in_join296 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_join297 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atts_in_groupby304 = new BitSet(new long[]{0x0000040000080000L});
	public static final BitSet FOLLOW_set_in_groupby306 = new BitSet(new long[]{0x0030608018600000L,0x0000000000000001L});
	public static final BitSet FOLLOW_fagregas_in_groupby313 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_8_in_groupby315 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_rel_in_groupby316 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_groupby317 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_in_orderby326 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_orders_in_orderby334 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_8_in_orderby336 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_rel_in_orderby337 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_orderby338 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_fagrega_in_agregation346 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_att_in_agregation350 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_8_in_agregation352 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_rel_in_agregation353 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_agregation354 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_att_in_atts366 = new BitSet(new long[]{0x0000000000000402L});
	public static final BitSet FOLLOW_10_in_atts369 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_att_in_atts371 = new BitSet(new long[]{0x0000000000000402L});
	public static final BitSet FOLLOW_cond1_in_conds1380 = new BitSet(new long[]{0x0040080020100002L});
	public static final BitSet FOLLOW_set_in_conds1383 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_cond1_in_conds1401 = new BitSet(new long[]{0x0040080020100002L});
	public static final BitSet FOLLOW_cond2_in_conds2410 = new BitSet(new long[]{0x0040080020100002L});
	public static final BitSet FOLLOW_set_in_conds2413 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_cond2_in_conds2431 = new BitSet(new long[]{0x0040080020100002L});
	public static final BitSet FOLLOW_con1_in_cond1442 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_con2_in_cond2453 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_con3_in_cond2456 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_att_in_orders465 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_8_in_orders467 = new BitSet(new long[]{0x0001100000000000L});
	public static final BitSet FOLLOW_order_in_orders468 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_orders469 = new BitSet(new long[]{0x0000000000000402L});
	public static final BitSet FOLLOW_10_in_orders472 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_att_in_orders474 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_8_in_orders476 = new BitSet(new long[]{0x0001100000000000L});
	public static final BitSet FOLLOW_order_in_orders477 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_orders478 = new BitSet(new long[]{0x0000000000000402L});
	public static final BitSet FOLLOW_fagrega_in_fagregas502 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_8_in_fagregas504 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_att_in_fagregas505 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_fagregas506 = new BitSet(new long[]{0x0000000000000402L});
	public static final BitSet FOLLOW_10_in_fagregas509 = new BitSet(new long[]{0x0030608018600000L,0x0000000000000001L});
	public static final BitSet FOLLOW_fagrega_in_fagregas511 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_8_in_fagregas513 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_att_in_fagregas514 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_fagregas515 = new BitSet(new long[]{0x0000000000000402L});
	public static final BitSet FOLLOW_att_in_con1571 = new BitSet(new long[]{0x000000000007C080L});
	public static final BitSet FOLLOW_set_in_con1573 = new BitSet(new long[]{0x0000020000000820L});
	public static final BitSet FOLLOW_cons_in_con1597 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rel_in_con2604 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_con2605 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_att_in_con2606 = new BitSet(new long[]{0x000000000007C080L});
	public static final BitSet FOLLOW_set_in_con2608 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_rel_in_con2632 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_con2633 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_att_in_con2634 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rel_in_con3641 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_con3642 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_att_in_con3643 = new BitSet(new long[]{0x000000000007C080L});
	public static final BitSet FOLLOW_set_in_con3645 = new BitSet(new long[]{0x0000020000000820L});
	public static final BitSet FOLLOW_cons_in_con3669 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_num_in_cons678 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_cad_in_cons682 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_11_in_num692 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_NUM_in_num696 = new BitSet(new long[]{0x0000000000001022L});
	public static final BitSet FOLLOW_12_in_num700 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_NUM_in_num702 = new BitSet(new long[]{0x0000000000000022L});
	public static final BitSet FOLLOW_41_in_cad713 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_CAD_in_cad714 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_41_in_cad715 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CAD_in_att722 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CAD_in_rel729 = new BitSet(new long[]{0x0000000000000002L});
}
