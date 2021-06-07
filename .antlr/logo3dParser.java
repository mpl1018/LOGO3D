// Generated from c:\Users\Owner\Desktop\UPC_LOCAL\LP\Pyhon\PRACTICA\GIT\LOGO3D\logo3d.g by ANTLR 4.8
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class logo3dParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, NUM=29, VAR=30, WS=31, COMMENT=32, 
		STRING=33;
	public static final int
		RULE_root = 0, RULE_routineBody = 1, RULE_statements = 2, RULE_expr = 3;
	private static String[] makeRuleNames() {
		return new String[] {
			"root", "routineBody", "statements", "expr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'PROC'", "'('", "','", "')'", "'IS'", "'END'", "'IF'", "'THEN'", 
			"'ELSE'", "'WHILE'", "'DO'", "'FOR'", "'FROM'", "'TO'", "':='", "'>>'", 
			"'<<'", "'#'", "'*'", "'/'", "'+'", "'-'", "'=='", "'>'", "'>='", "'!='", 
			"'<'", "'<='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "NUM", "VAR", "WS", "COMMENT", "STRING"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "logo3d.g"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public logo3dParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class RootContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(logo3dParser.EOF, 0); }
		public List<StatementsContext> statements() {
			return getRuleContexts(StatementsContext.class);
		}
		public StatementsContext statements(int i) {
			return getRuleContext(StatementsContext.class,i);
		}
		public RootContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_root; }
	}

	public final RootContext root() throws RecognitionException {
		RootContext _localctx = new RootContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_root);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(11);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__6) | (1L << T__9) | (1L << T__11) | (1L << T__15) | (1L << T__16) | (1L << VAR))) != 0)) {
				{
				{
				setState(8);
				statements();
				}
				}
				setState(13);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(14);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RoutineBodyContext extends ParserRuleContext {
		public List<StatementsContext> statements() {
			return getRuleContexts(StatementsContext.class);
		}
		public StatementsContext statements(int i) {
			return getRuleContext(StatementsContext.class,i);
		}
		public RoutineBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_routineBody; }
	}

	public final RoutineBodyContext routineBody() throws RecognitionException {
		RoutineBodyContext _localctx = new RoutineBodyContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_routineBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(19);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__6) | (1L << T__9) | (1L << T__11) | (1L << T__15) | (1L << T__16) | (1L << VAR))) != 0)) {
				{
				{
				setState(16);
				statements();
				}
				}
				setState(21);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementsContext extends ParserRuleContext {
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
	 
		public StatementsContext() { }
		public void copyFrom(StatementsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ReadContext extends StatementsContext {
		public TerminalNode VAR() { return getToken(logo3dParser.VAR, 0); }
		public ReadContext(StatementsContext ctx) { copyFrom(ctx); }
	}
	public static class WriteContext extends StatementsContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public WriteContext(StatementsContext ctx) { copyFrom(ctx); }
	}
	public static class AsignacionContext extends StatementsContext {
		public TerminalNode VAR() { return getToken(logo3dParser.VAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AsignacionContext(StatementsContext ctx) { copyFrom(ctx); }
	}
	public static class IfElseContext extends StatementsContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<StatementsContext> statements() {
			return getRuleContexts(StatementsContext.class);
		}
		public StatementsContext statements(int i) {
			return getRuleContext(StatementsContext.class,i);
		}
		public IfElseContext(StatementsContext ctx) { copyFrom(ctx); }
	}
	public static class RoutineCallContext extends StatementsContext {
		public TerminalNode VAR() { return getToken(logo3dParser.VAR, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public RoutineCallContext(StatementsContext ctx) { copyFrom(ctx); }
	}
	public static class ForContext extends StatementsContext {
		public TerminalNode VAR() { return getToken(logo3dParser.VAR, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<StatementsContext> statements() {
			return getRuleContexts(StatementsContext.class);
		}
		public StatementsContext statements(int i) {
			return getRuleContext(StatementsContext.class,i);
		}
		public ForContext(StatementsContext ctx) { copyFrom(ctx); }
	}
	public static class RoutineDefContext extends StatementsContext {
		public List<TerminalNode> VAR() { return getTokens(logo3dParser.VAR); }
		public TerminalNode VAR(int i) {
			return getToken(logo3dParser.VAR, i);
		}
		public RoutineBodyContext routineBody() {
			return getRuleContext(RoutineBodyContext.class,0);
		}
		public RoutineDefContext(StatementsContext ctx) { copyFrom(ctx); }
	}
	public static class WhileContext extends StatementsContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<StatementsContext> statements() {
			return getRuleContexts(StatementsContext.class);
		}
		public StatementsContext statements(int i) {
			return getRuleContext(StatementsContext.class,i);
		}
		public WhileContext(StatementsContext ctx) { copyFrom(ctx); }
	}
	public static class IfContext extends StatementsContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<StatementsContext> statements() {
			return getRuleContexts(StatementsContext.class);
		}
		public StatementsContext statements(int i) {
			return getRuleContext(StatementsContext.class,i);
		}
		public IfContext(StatementsContext ctx) { copyFrom(ctx); }
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statements);
		int _la;
		try {
			setState(116);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				_localctx = new RoutineDefContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(22);
				match(T__0);
				setState(23);
				match(VAR);
				setState(24);
				match(T__1);
				setState(28);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==VAR) {
					{
					{
					setState(25);
					match(VAR);
					}
					}
					setState(30);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(35);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(31);
					match(T__2);
					setState(32);
					match(VAR);
					}
					}
					setState(37);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(38);
				match(T__3);
				setState(39);
				match(T__4);
				setState(40);
				routineBody();
				setState(41);
				match(T__5);
				}
				break;
			case 2:
				_localctx = new RoutineCallContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(43);
				match(VAR);
				setState(44);
				match(T__1);
				setState(48);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__21) | (1L << NUM) | (1L << VAR) | (1L << STRING))) != 0)) {
					{
					{
					setState(45);
					expr(0);
					}
					}
					setState(50);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(55);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(51);
					match(T__2);
					setState(52);
					expr(0);
					}
					}
					setState(57);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(58);
				match(T__3);
				}
				break;
			case 3:
				_localctx = new IfContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(59);
				match(T__6);
				setState(60);
				expr(0);
				setState(61);
				match(T__7);
				setState(63); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(62);
					statements();
					}
					}
					setState(65); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__6) | (1L << T__9) | (1L << T__11) | (1L << T__15) | (1L << T__16) | (1L << VAR))) != 0) );
				setState(67);
				match(T__5);
				}
				break;
			case 4:
				_localctx = new IfElseContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(69);
				match(T__6);
				setState(70);
				expr(0);
				setState(71);
				match(T__7);
				setState(73); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(72);
					statements();
					}
					}
					setState(75); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__6) | (1L << T__9) | (1L << T__11) | (1L << T__15) | (1L << T__16) | (1L << VAR))) != 0) );
				setState(77);
				match(T__8);
				setState(79); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(78);
					statements();
					}
					}
					setState(81); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__6) | (1L << T__9) | (1L << T__11) | (1L << T__15) | (1L << T__16) | (1L << VAR))) != 0) );
				setState(83);
				match(T__5);
				}
				break;
			case 5:
				_localctx = new WhileContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(85);
				match(T__9);
				setState(86);
				expr(0);
				setState(87);
				match(T__10);
				setState(89); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(88);
					statements();
					}
					}
					setState(91); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__6) | (1L << T__9) | (1L << T__11) | (1L << T__15) | (1L << T__16) | (1L << VAR))) != 0) );
				setState(93);
				match(T__5);
				}
				break;
			case 6:
				_localctx = new ForContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(95);
				match(T__11);
				setState(96);
				match(VAR);
				setState(97);
				match(T__12);
				setState(98);
				expr(0);
				setState(99);
				match(T__13);
				setState(100);
				expr(0);
				setState(101);
				match(T__10);
				setState(103); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(102);
					statements();
					}
					}
					setState(105); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__6) | (1L << T__9) | (1L << T__11) | (1L << T__15) | (1L << T__16) | (1L << VAR))) != 0) );
				setState(107);
				match(T__5);
				}
				break;
			case 7:
				_localctx = new AsignacionContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(109);
				match(VAR);
				setState(110);
				match(T__14);
				setState(111);
				expr(0);
				}
				break;
			case 8:
				_localctx = new ReadContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(112);
				match(T__15);
				setState(113);
				match(VAR);
				}
				break;
			case 9:
				_localctx = new WriteContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(114);
				match(T__16);
				setState(115);
				expr(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ValContext extends ExprContext {
		public TerminalNode NUM() { return getToken(logo3dParser.NUM, 0); }
		public ValContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class NotEqContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public NotEqContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class SubContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public SubContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class BraquetsContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BraquetsContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class VarContext extends ExprContext {
		public TerminalNode VAR() { return getToken(logo3dParser.VAR, 0); }
		public VarContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class SumContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public SumContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class GrContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public GrContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class EqContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public EqContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class StrContext extends ExprContext {
		public TerminalNode STRING() { return getToken(logo3dParser.STRING, 0); }
		public StrContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class DivContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public DivContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class LessEqContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public LessEqContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class NegContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NegContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class MultContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public MultContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class GrEContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public GrEContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class LessContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public LessContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class PowerContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public PowerContext(ExprContext ctx) { copyFrom(ctx); }
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				_localctx = new BraquetsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(119);
				match(T__1);
				setState(120);
				expr(0);
				setState(121);
				match(T__3);
				}
				break;
			case T__21:
				{
				_localctx = new NegContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(123);
				match(T__21);
				setState(124);
				expr(4);
				}
				break;
			case NUM:
				{
				_localctx = new ValContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(125);
				match(NUM);
				}
				break;
			case VAR:
				{
				_localctx = new VarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(126);
				match(VAR);
				}
				break;
			case STRING:
				{
				_localctx = new StrContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(127);
				match(STRING);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(165);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(163);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						_localctx = new PowerContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(130);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(131);
						match(T__17);
						setState(132);
						expr(16);
						}
						break;
					case 2:
						{
						_localctx = new MultContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(133);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(134);
						match(T__18);
						setState(135);
						expr(15);
						}
						break;
					case 3:
						{
						_localctx = new DivContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(136);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(137);
						match(T__19);
						setState(138);
						expr(14);
						}
						break;
					case 4:
						{
						_localctx = new SumContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(139);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(140);
						match(T__20);
						setState(141);
						expr(13);
						}
						break;
					case 5:
						{
						_localctx = new SubContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(142);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(143);
						match(T__21);
						setState(144);
						expr(12);
						}
						break;
					case 6:
						{
						_localctx = new EqContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(145);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(146);
						match(T__22);
						setState(147);
						expr(11);
						}
						break;
					case 7:
						{
						_localctx = new GrContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(148);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(149);
						match(T__23);
						setState(150);
						expr(10);
						}
						break;
					case 8:
						{
						_localctx = new GrEContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(151);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(152);
						match(T__24);
						setState(153);
						expr(9);
						}
						break;
					case 9:
						{
						_localctx = new NotEqContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(154);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(155);
						match(T__25);
						setState(156);
						expr(8);
						}
						break;
					case 10:
						{
						_localctx = new LessContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(157);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(158);
						match(T__26);
						setState(159);
						expr(7);
						}
						break;
					case 11:
						{
						_localctx = new LessEqContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(160);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(161);
						match(T__27);
						setState(162);
						expr(6);
						}
						break;
					}
					} 
				}
				setState(167);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 3:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 15);
		case 1:
			return precpred(_ctx, 14);
		case 2:
			return precpred(_ctx, 13);
		case 3:
			return precpred(_ctx, 12);
		case 4:
			return precpred(_ctx, 11);
		case 5:
			return precpred(_ctx, 10);
		case 6:
			return precpred(_ctx, 9);
		case 7:
			return precpred(_ctx, 8);
		case 8:
			return precpred(_ctx, 7);
		case 9:
			return precpred(_ctx, 6);
		case 10:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3#\u00ab\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\3\2\7\2\f\n\2\f\2\16\2\17\13\2\3\2\3\2\3\3\7\3"+
		"\24\n\3\f\3\16\3\27\13\3\3\4\3\4\3\4\3\4\7\4\35\n\4\f\4\16\4 \13\4\3\4"+
		"\3\4\7\4$\n\4\f\4\16\4\'\13\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4\61\n"+
		"\4\f\4\16\4\64\13\4\3\4\3\4\7\48\n\4\f\4\16\4;\13\4\3\4\3\4\3\4\3\4\3"+
		"\4\6\4B\n\4\r\4\16\4C\3\4\3\4\3\4\3\4\3\4\3\4\6\4L\n\4\r\4\16\4M\3\4\3"+
		"\4\6\4R\n\4\r\4\16\4S\3\4\3\4\3\4\3\4\3\4\3\4\6\4\\\n\4\r\4\16\4]\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\6\4j\n\4\r\4\16\4k\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\5\4w\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\5\5\u0083\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\7\5\u00a6\n\5\f\5\16\5\u00a9\13\5\3\5\2\3\b\6\2\4\6\b\2\2\2\u00c8"+
		"\2\r\3\2\2\2\4\25\3\2\2\2\6v\3\2\2\2\b\u0082\3\2\2\2\n\f\5\6\4\2\13\n"+
		"\3\2\2\2\f\17\3\2\2\2\r\13\3\2\2\2\r\16\3\2\2\2\16\20\3\2\2\2\17\r\3\2"+
		"\2\2\20\21\7\2\2\3\21\3\3\2\2\2\22\24\5\6\4\2\23\22\3\2\2\2\24\27\3\2"+
		"\2\2\25\23\3\2\2\2\25\26\3\2\2\2\26\5\3\2\2\2\27\25\3\2\2\2\30\31\7\3"+
		"\2\2\31\32\7 \2\2\32\36\7\4\2\2\33\35\7 \2\2\34\33\3\2\2\2\35 \3\2\2\2"+
		"\36\34\3\2\2\2\36\37\3\2\2\2\37%\3\2\2\2 \36\3\2\2\2!\"\7\5\2\2\"$\7 "+
		"\2\2#!\3\2\2\2$\'\3\2\2\2%#\3\2\2\2%&\3\2\2\2&(\3\2\2\2\'%\3\2\2\2()\7"+
		"\6\2\2)*\7\7\2\2*+\5\4\3\2+,\7\b\2\2,w\3\2\2\2-.\7 \2\2.\62\7\4\2\2/\61"+
		"\5\b\5\2\60/\3\2\2\2\61\64\3\2\2\2\62\60\3\2\2\2\62\63\3\2\2\2\639\3\2"+
		"\2\2\64\62\3\2\2\2\65\66\7\5\2\2\668\5\b\5\2\67\65\3\2\2\28;\3\2\2\29"+
		"\67\3\2\2\29:\3\2\2\2:<\3\2\2\2;9\3\2\2\2<w\7\6\2\2=>\7\t\2\2>?\5\b\5"+
		"\2?A\7\n\2\2@B\5\6\4\2A@\3\2\2\2BC\3\2\2\2CA\3\2\2\2CD\3\2\2\2DE\3\2\2"+
		"\2EF\7\b\2\2Fw\3\2\2\2GH\7\t\2\2HI\5\b\5\2IK\7\n\2\2JL\5\6\4\2KJ\3\2\2"+
		"\2LM\3\2\2\2MK\3\2\2\2MN\3\2\2\2NO\3\2\2\2OQ\7\13\2\2PR\5\6\4\2QP\3\2"+
		"\2\2RS\3\2\2\2SQ\3\2\2\2ST\3\2\2\2TU\3\2\2\2UV\7\b\2\2Vw\3\2\2\2WX\7\f"+
		"\2\2XY\5\b\5\2Y[\7\r\2\2Z\\\5\6\4\2[Z\3\2\2\2\\]\3\2\2\2][\3\2\2\2]^\3"+
		"\2\2\2^_\3\2\2\2_`\7\b\2\2`w\3\2\2\2ab\7\16\2\2bc\7 \2\2cd\7\17\2\2de"+
		"\5\b\5\2ef\7\20\2\2fg\5\b\5\2gi\7\r\2\2hj\5\6\4\2ih\3\2\2\2jk\3\2\2\2"+
		"ki\3\2\2\2kl\3\2\2\2lm\3\2\2\2mn\7\b\2\2nw\3\2\2\2op\7 \2\2pq\7\21\2\2"+
		"qw\5\b\5\2rs\7\22\2\2sw\7 \2\2tu\7\23\2\2uw\5\b\5\2v\30\3\2\2\2v-\3\2"+
		"\2\2v=\3\2\2\2vG\3\2\2\2vW\3\2\2\2va\3\2\2\2vo\3\2\2\2vr\3\2\2\2vt\3\2"+
		"\2\2w\7\3\2\2\2xy\b\5\1\2yz\7\4\2\2z{\5\b\5\2{|\7\6\2\2|\u0083\3\2\2\2"+
		"}~\7\30\2\2~\u0083\5\b\5\6\177\u0083\7\37\2\2\u0080\u0083\7 \2\2\u0081"+
		"\u0083\7#\2\2\u0082x\3\2\2\2\u0082}\3\2\2\2\u0082\177\3\2\2\2\u0082\u0080"+
		"\3\2\2\2\u0082\u0081\3\2\2\2\u0083\u00a7\3\2\2\2\u0084\u0085\f\21\2\2"+
		"\u0085\u0086\7\24\2\2\u0086\u00a6\5\b\5\22\u0087\u0088\f\20\2\2\u0088"+
		"\u0089\7\25\2\2\u0089\u00a6\5\b\5\21\u008a\u008b\f\17\2\2\u008b\u008c"+
		"\7\26\2\2\u008c\u00a6\5\b\5\20\u008d\u008e\f\16\2\2\u008e\u008f\7\27\2"+
		"\2\u008f\u00a6\5\b\5\17\u0090\u0091\f\r\2\2\u0091\u0092\7\30\2\2\u0092"+
		"\u00a6\5\b\5\16\u0093\u0094\f\f\2\2\u0094\u0095\7\31\2\2\u0095\u00a6\5"+
		"\b\5\r\u0096\u0097\f\13\2\2\u0097\u0098\7\32\2\2\u0098\u00a6\5\b\5\f\u0099"+
		"\u009a\f\n\2\2\u009a\u009b\7\33\2\2\u009b\u00a6\5\b\5\13\u009c\u009d\f"+
		"\t\2\2\u009d\u009e\7\34\2\2\u009e\u00a6\5\b\5\n\u009f\u00a0\f\b\2\2\u00a0"+
		"\u00a1\7\35\2\2\u00a1\u00a6\5\b\5\t\u00a2\u00a3\f\7\2\2\u00a3\u00a4\7"+
		"\36\2\2\u00a4\u00a6\5\b\5\b\u00a5\u0084\3\2\2\2\u00a5\u0087\3\2\2\2\u00a5"+
		"\u008a\3\2\2\2\u00a5\u008d\3\2\2\2\u00a5\u0090\3\2\2\2\u00a5\u0093\3\2"+
		"\2\2\u00a5\u0096\3\2\2\2\u00a5\u0099\3\2\2\2\u00a5\u009c\3\2\2\2\u00a5"+
		"\u009f\3\2\2\2\u00a5\u00a2\3\2\2\2\u00a6\u00a9\3\2\2\2\u00a7\u00a5\3\2"+
		"\2\2\u00a7\u00a8\3\2\2\2\u00a8\t\3\2\2\2\u00a9\u00a7\3\2\2\2\21\r\25\36"+
		"%\629CMS]kv\u0082\u00a5\u00a7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}