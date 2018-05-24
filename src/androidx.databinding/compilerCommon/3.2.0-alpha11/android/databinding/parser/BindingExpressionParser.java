// Generated from BindingExpression.g4 by ANTLR 4.5.3
package android.databinding.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BindingExpressionParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, THIS=45, VoidLiteral=46, 
		IntegerLiteral=47, FloatingPointLiteral=48, BooleanLiteral=49, CharacterLiteral=50, 
		SingleQuoteString=51, DoubleQuoteString=52, NullLiteral=53, Identifier=54, 
		WS=55, ResourceReference=56, PackageName=57, ResourceType=58;
	public static final int
		RULE_bindingSyntax = 0, RULE_defaults = 1, RULE_constantValue = 2, RULE_lambdaExpression = 3, 
		RULE_lambdaParameters = 4, RULE_inferredFormalParameterList = 5, RULE_expression = 6, 
		RULE_classExtraction = 7, RULE_expressionList = 8, RULE_literal = 9, RULE_identifier = 10, 
		RULE_javaLiteral = 11, RULE_stringLiteral = 12, RULE_explicitGenericInvocation = 13, 
		RULE_typeArguments = 14, RULE_type = 15, RULE_explicitGenericInvocationSuffix = 16, 
		RULE_arguments = 17, RULE_classOrInterfaceType = 18, RULE_primitiveType = 19, 
		RULE_resources = 20, RULE_resourceParameters = 21;
	public static final String[] ruleNames = {
		"bindingSyntax", "defaults", "constantValue", "lambdaExpression", "lambdaParameters", 
		"inferredFormalParameterList", "expression", "classExtraction", "expressionList", 
		"literal", "identifier", "javaLiteral", "stringLiteral", "explicitGenericInvocation", 
		"typeArguments", "type", "explicitGenericInvocationSuffix", "arguments", 
		"classOrInterfaceType", "primitiveType", "resources", "resourceParameters"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "','", "'default'", "'='", "'->'", "'('", "')'", "'.'", "'::'", 
		"'['", "']'", "'+'", "'-'", "'~'", "'!'", "'*'", "'/'", "'%'", "'<<'", 
		"'>>>'", "'>>'", "'<='", "'>='", "'>'", "'<'", "'instanceof'", "'=='", 
		"'!='", "'&'", "'^'", "'|'", "'&&'", "'||'", "'?'", "':'", "'??'", "'class'", 
		"'boolean'", "'char'", "'byte'", "'short'", "'int'", "'long'", "'float'", 
		"'double'", "'this'", null, null, null, null, null, null, null, "'null'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, "THIS", "VoidLiteral", 
		"IntegerLiteral", "FloatingPointLiteral", "BooleanLiteral", "CharacterLiteral", 
		"SingleQuoteString", "DoubleQuoteString", "NullLiteral", "Identifier", 
		"WS", "ResourceReference", "PackageName", "ResourceType"
	};
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
	public String getGrammarFileName() { return "BindingExpression.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public BindingExpressionParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class BindingSyntaxContext extends ParserRuleContext {
		public BindingSyntaxContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bindingSyntax; }
	 
		public BindingSyntaxContext() { }
		public void copyFrom(BindingSyntaxContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RootExprContext extends BindingSyntaxContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DefaultsContext defaults() {
			return getRuleContext(DefaultsContext.class,0);
		}
		public RootExprContext(BindingSyntaxContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).enterRootExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).exitRootExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BindingExpressionVisitor ) return ((BindingExpressionVisitor<? extends T>)visitor).visitRootExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RootLambdaContext extends BindingSyntaxContext {
		public LambdaExpressionContext lambdaExpression() {
			return getRuleContext(LambdaExpressionContext.class,0);
		}
		public RootLambdaContext(BindingSyntaxContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).enterRootLambda(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).exitRootLambda(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BindingExpressionVisitor ) return ((BindingExpressionVisitor<? extends T>)visitor).visitRootLambda(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BindingSyntaxContext bindingSyntax() throws RecognitionException {
		BindingSyntaxContext _localctx = new BindingSyntaxContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_bindingSyntax);
		int _la;
		try {
			setState(49);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new RootExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(44);
				expression(0);
				setState(46);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(45);
					defaults();
					}
				}

				}
				break;
			case 2:
				_localctx = new RootLambdaContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(48);
				lambdaExpression();
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

	public static class DefaultsContext extends ParserRuleContext {
		public ConstantValueContext constantValue() {
			return getRuleContext(ConstantValueContext.class,0);
		}
		public DefaultsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defaults; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).enterDefaults(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).exitDefaults(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BindingExpressionVisitor ) return ((BindingExpressionVisitor<? extends T>)visitor).visitDefaults(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefaultsContext defaults() throws RecognitionException {
		DefaultsContext _localctx = new DefaultsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_defaults);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			match(T__0);
			setState(52);
			match(T__1);
			setState(53);
			match(T__2);
			setState(54);
			constantValue();
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

	public static class ConstantValueContext extends ParserRuleContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public TerminalNode ResourceReference() { return getToken(BindingExpressionParser.ResourceReference, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ConstantValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).enterConstantValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).exitConstantValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BindingExpressionVisitor ) return ((BindingExpressionVisitor<? extends T>)visitor).visitConstantValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantValueContext constantValue() throws RecognitionException {
		ConstantValueContext _localctx = new ConstantValueContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_constantValue);
		try {
			setState(59);
			switch (_input.LA(1)) {
			case IntegerLiteral:
			case FloatingPointLiteral:
			case BooleanLiteral:
			case CharacterLiteral:
			case SingleQuoteString:
			case DoubleQuoteString:
			case NullLiteral:
				enterOuterAlt(_localctx, 1);
				{
				setState(56);
				literal();
				}
				break;
			case ResourceReference:
				enterOuterAlt(_localctx, 2);
				{
				setState(57);
				match(ResourceReference);
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 3);
				{
				setState(58);
				identifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class LambdaExpressionContext extends ParserRuleContext {
		public LambdaParametersContext args;
		public ExpressionContext expr;
		public LambdaParametersContext lambdaParameters() {
			return getRuleContext(LambdaParametersContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public LambdaExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).enterLambdaExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).exitLambdaExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BindingExpressionVisitor ) return ((BindingExpressionVisitor<? extends T>)visitor).visitLambdaExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LambdaExpressionContext lambdaExpression() throws RecognitionException {
		LambdaExpressionContext _localctx = new LambdaExpressionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_lambdaExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			((LambdaExpressionContext)_localctx).args = lambdaParameters();
			setState(62);
			match(T__3);
			setState(63);
			((LambdaExpressionContext)_localctx).expr = expression(0);
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

	public static class LambdaParametersContext extends ParserRuleContext {
		public LambdaParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaParameters; }
	 
		public LambdaParametersContext() { }
		public void copyFrom(LambdaParametersContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SingleLambdaParameterContext extends LambdaParametersContext {
		public TerminalNode Identifier() { return getToken(BindingExpressionParser.Identifier, 0); }
		public SingleLambdaParameterContext(LambdaParametersContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).enterSingleLambdaParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).exitSingleLambdaParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BindingExpressionVisitor ) return ((BindingExpressionVisitor<? extends T>)visitor).visitSingleLambdaParameter(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LambdaParameterListContext extends LambdaParametersContext {
		public InferredFormalParameterListContext params;
		public InferredFormalParameterListContext inferredFormalParameterList() {
			return getRuleContext(InferredFormalParameterListContext.class,0);
		}
		public LambdaParameterListContext(LambdaParametersContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).enterLambdaParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).exitLambdaParameterList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BindingExpressionVisitor ) return ((BindingExpressionVisitor<? extends T>)visitor).visitLambdaParameterList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LambdaParametersContext lambdaParameters() throws RecognitionException {
		LambdaParametersContext _localctx = new LambdaParametersContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_lambdaParameters);
		int _la;
		try {
			setState(71);
			switch (_input.LA(1)) {
			case Identifier:
				_localctx = new SingleLambdaParameterContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(65);
				match(Identifier);
				}
				break;
			case T__4:
				_localctx = new LambdaParameterListContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(66);
				match(T__4);
				setState(68);
				_la = _input.LA(1);
				if (_la==Identifier) {
					{
					setState(67);
					((LambdaParameterListContext)_localctx).params = inferredFormalParameterList();
					}
				}

				setState(70);
				match(T__5);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class InferredFormalParameterListContext extends ParserRuleContext {
		public List<TerminalNode> Identifier() { return getTokens(BindingExpressionParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(BindingExpressionParser.Identifier, i);
		}
		public InferredFormalParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inferredFormalParameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).enterInferredFormalParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).exitInferredFormalParameterList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BindingExpressionVisitor ) return ((BindingExpressionVisitor<? extends T>)visitor).visitInferredFormalParameterList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InferredFormalParameterListContext inferredFormalParameterList() throws RecognitionException {
		InferredFormalParameterListContext _localctx = new InferredFormalParameterListContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_inferredFormalParameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			match(Identifier);
			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(74);
				match(T__0);
				setState(75);
				match(Identifier);
				}
				}
				setState(80);
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

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CastOpContext extends ExpressionContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public CastOpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).enterCastOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).exitCastOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BindingExpressionVisitor ) return ((BindingExpressionVisitor<? extends T>)visitor).visitCastOp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ComparisonOpContext extends ExpressionContext {
		public ExpressionContext left;
		public Token op;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ComparisonOpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).enterComparisonOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).exitComparisonOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BindingExpressionVisitor ) return ((BindingExpressionVisitor<? extends T>)visitor).visitComparisonOp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnaryOpContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public UnaryOpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).enterUnaryOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).exitUnaryOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BindingExpressionVisitor ) return ((BindingExpressionVisitor<? extends T>)visitor).visitUnaryOp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BracketOpContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public BracketOpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).enterBracketOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).exitBracketOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BindingExpressionVisitor ) return ((BindingExpressionVisitor<? extends T>)visitor).visitBracketOp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ResourceContext extends ExpressionContext {
		public ResourcesContext resources() {
			return getRuleContext(ResourcesContext.class,0);
		}
		public ResourceContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).enterResource(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).exitResource(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BindingExpressionVisitor ) return ((BindingExpressionVisitor<? extends T>)visitor).visitResource(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class QuestionQuestionOpContext extends ExpressionContext {
		public ExpressionContext left;
		public Token op;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public QuestionQuestionOpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).enterQuestionQuestionOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).exitQuestionQuestionOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BindingExpressionVisitor ) return ((BindingExpressionVisitor<? extends T>)visitor).visitQuestionQuestionOp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GroupingContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public GroupingContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).enterGrouping(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).exitGrouping(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BindingExpressionVisitor ) return ((BindingExpressionVisitor<? extends T>)visitor).visitGrouping(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MethodInvocationContext extends ExpressionContext {
		public ExpressionContext target;
		public Token methodName;
		public ExpressionListContext args;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(BindingExpressionParser.Identifier, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public MethodInvocationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).enterMethodInvocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).exitMethodInvocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BindingExpressionVisitor ) return ((BindingExpressionVisitor<? extends T>)visitor).visitMethodInvocation(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BitShiftOpContext extends ExpressionContext {
		public ExpressionContext left;
		public Token op;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public BitShiftOpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).enterBitShiftOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).exitBitShiftOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BindingExpressionVisitor ) return ((BindingExpressionVisitor<? extends T>)visitor).visitBitShiftOp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AndOrOpContext extends ExpressionContext {
		public ExpressionContext left;
		public Token op;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public AndOrOpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).enterAndOrOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).exitAndOrOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BindingExpressionVisitor ) return ((BindingExpressionVisitor<? extends T>)visitor).visitAndOrOp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TernaryOpContext extends ExpressionContext {
		public ExpressionContext left;
		public Token op;
		public ExpressionContext iftrue;
		public ExpressionContext iffalse;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TernaryOpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).enterTernaryOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).exitTernaryOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BindingExpressionVisitor ) return ((BindingExpressionVisitor<? extends T>)visitor).visitTernaryOp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrimaryContext extends ExpressionContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public TerminalNode VoidLiteral() { return getToken(BindingExpressionParser.VoidLiteral, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ClassExtractionContext classExtraction() {
			return getRuleContext(ClassExtractionContext.class,0);
		}
		public PrimaryContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).enterPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).exitPrimary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BindingExpressionVisitor ) return ((BindingExpressionVisitor<? extends T>)visitor).visitPrimary(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DotOpContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(BindingExpressionParser.Identifier, 0); }
		public DotOpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).enterDotOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).exitDotOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BindingExpressionVisitor ) return ((BindingExpressionVisitor<? extends T>)visitor).visitDotOp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GlobalMethodInvocationContext extends ExpressionContext {
		public Token methodName;
		public ExpressionListContext args;
		public TerminalNode Identifier() { return getToken(BindingExpressionParser.Identifier, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public GlobalMethodInvocationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).enterGlobalMethodInvocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).exitGlobalMethodInvocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BindingExpressionVisitor ) return ((BindingExpressionVisitor<? extends T>)visitor).visitGlobalMethodInvocation(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MathOpContext extends ExpressionContext {
		public ExpressionContext left;
		public Token op;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public MathOpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).enterMathOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).exitMathOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BindingExpressionVisitor ) return ((BindingExpressionVisitor<? extends T>)visitor).visitMathOp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InstanceOfOpContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public InstanceOfOpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).enterInstanceOfOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).exitInstanceOfOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BindingExpressionVisitor ) return ((BindingExpressionVisitor<? extends T>)visitor).visitInstanceOfOp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BinaryOpContext extends ExpressionContext {
		public ExpressionContext left;
		public Token op;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public BinaryOpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).enterBinaryOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).exitBinaryOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BindingExpressionVisitor ) return ((BindingExpressionVisitor<? extends T>)visitor).visitBinaryOp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunctionRefContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(BindingExpressionParser.Identifier, 0); }
		public FunctionRefContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).enterFunctionRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).exitFunctionRef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BindingExpressionVisitor ) return ((BindingExpressionVisitor<? extends T>)visitor).visitFunctionRef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				_localctx = new GroupingContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(82);
				match(T__4);
				setState(83);
				expression(0);
				setState(84);
				match(T__5);
				}
				break;
			case 2:
				{
				_localctx = new PrimaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(86);
				literal();
				}
				break;
			case 3:
				{
				_localctx = new PrimaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(87);
				match(VoidLiteral);
				}
				break;
			case 4:
				{
				_localctx = new PrimaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(88);
				identifier();
				}
				break;
			case 5:
				{
				_localctx = new PrimaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(89);
				classExtraction();
				}
				break;
			case 6:
				{
				_localctx = new ResourceContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(90);
				resources();
				}
				break;
			case 7:
				{
				_localctx = new GlobalMethodInvocationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(91);
				((GlobalMethodInvocationContext)_localctx).methodName = match(Identifier);
				setState(92);
				match(T__4);
				setState(94);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << VoidLiteral) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << SingleQuoteString) | (1L << DoubleQuoteString) | (1L << NullLiteral) | (1L << Identifier) | (1L << ResourceReference))) != 0)) {
					{
					setState(93);
					((GlobalMethodInvocationContext)_localctx).args = expressionList();
					}
				}

				setState(96);
				match(T__5);
				}
				break;
			case 8:
				{
				_localctx = new CastOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(97);
				match(T__4);
				setState(98);
				type();
				setState(99);
				match(T__5);
				setState(100);
				expression(16);
				}
				break;
			case 9:
				{
				_localctx = new UnaryOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(102);
				((UnaryOpContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__10 || _la==T__11) ) {
					((UnaryOpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(103);
				expression(15);
				}
				break;
			case 10:
				{
				_localctx = new UnaryOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(104);
				((UnaryOpContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__12 || _la==T__13) ) {
					((UnaryOpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(105);
				expression(14);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(171);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(169);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new MathOpContext(new ExpressionContext(_parentctx, _parentState));
						((MathOpContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(108);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(109);
						((MathOpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__15) | (1L << T__16))) != 0)) ) {
							((MathOpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(110);
						((MathOpContext)_localctx).right = expression(14);
						}
						break;
					case 2:
						{
						_localctx = new MathOpContext(new ExpressionContext(_parentctx, _parentState));
						((MathOpContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(111);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(112);
						((MathOpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__10 || _la==T__11) ) {
							((MathOpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(113);
						((MathOpContext)_localctx).right = expression(13);
						}
						break;
					case 3:
						{
						_localctx = new BitShiftOpContext(new ExpressionContext(_parentctx, _parentState));
						((BitShiftOpContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(114);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(115);
						((BitShiftOpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__17) | (1L << T__18) | (1L << T__19))) != 0)) ) {
							((BitShiftOpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(116);
						((BitShiftOpContext)_localctx).right = expression(12);
						}
						break;
					case 4:
						{
						_localctx = new ComparisonOpContext(new ExpressionContext(_parentctx, _parentState));
						((ComparisonOpContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(117);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(118);
						((ComparisonOpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23))) != 0)) ) {
							((ComparisonOpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(119);
						((ComparisonOpContext)_localctx).right = expression(11);
						}
						break;
					case 5:
						{
						_localctx = new ComparisonOpContext(new ExpressionContext(_parentctx, _parentState));
						((ComparisonOpContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(120);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(121);
						((ComparisonOpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__25 || _la==T__26) ) {
							((ComparisonOpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(122);
						((ComparisonOpContext)_localctx).right = expression(9);
						}
						break;
					case 6:
						{
						_localctx = new BinaryOpContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryOpContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(123);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(124);
						((BinaryOpContext)_localctx).op = match(T__27);
						setState(125);
						((BinaryOpContext)_localctx).right = expression(8);
						}
						break;
					case 7:
						{
						_localctx = new BinaryOpContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryOpContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(126);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(127);
						((BinaryOpContext)_localctx).op = match(T__28);
						setState(128);
						((BinaryOpContext)_localctx).right = expression(7);
						}
						break;
					case 8:
						{
						_localctx = new BinaryOpContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryOpContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(129);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(130);
						((BinaryOpContext)_localctx).op = match(T__29);
						setState(131);
						((BinaryOpContext)_localctx).right = expression(6);
						}
						break;
					case 9:
						{
						_localctx = new AndOrOpContext(new ExpressionContext(_parentctx, _parentState));
						((AndOrOpContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(132);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(133);
						((AndOrOpContext)_localctx).op = match(T__30);
						setState(134);
						((AndOrOpContext)_localctx).right = expression(5);
						}
						break;
					case 10:
						{
						_localctx = new AndOrOpContext(new ExpressionContext(_parentctx, _parentState));
						((AndOrOpContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(135);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(136);
						((AndOrOpContext)_localctx).op = match(T__31);
						setState(137);
						((AndOrOpContext)_localctx).right = expression(4);
						}
						break;
					case 11:
						{
						_localctx = new TernaryOpContext(new ExpressionContext(_parentctx, _parentState));
						((TernaryOpContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(138);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(139);
						((TernaryOpContext)_localctx).op = match(T__32);
						setState(140);
						((TernaryOpContext)_localctx).iftrue = expression(0);
						setState(141);
						match(T__33);
						setState(142);
						((TernaryOpContext)_localctx).iffalse = expression(2);
						}
						break;
					case 12:
						{
						_localctx = new QuestionQuestionOpContext(new ExpressionContext(_parentctx, _parentState));
						((QuestionQuestionOpContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(144);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(145);
						((QuestionQuestionOpContext)_localctx).op = match(T__34);
						setState(146);
						((QuestionQuestionOpContext)_localctx).right = expression(2);
						}
						break;
					case 13:
						{
						_localctx = new DotOpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(147);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(148);
						match(T__6);
						setState(149);
						match(Identifier);
						}
						break;
					case 14:
						{
						_localctx = new FunctionRefContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(150);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(151);
						match(T__7);
						setState(152);
						match(Identifier);
						}
						break;
					case 15:
						{
						_localctx = new BracketOpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(153);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(154);
						match(T__8);
						setState(155);
						expression(0);
						setState(156);
						match(T__9);
						}
						break;
					case 16:
						{
						_localctx = new MethodInvocationContext(new ExpressionContext(_parentctx, _parentState));
						((MethodInvocationContext)_localctx).target = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(158);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(159);
						match(T__6);
						setState(160);
						((MethodInvocationContext)_localctx).methodName = match(Identifier);
						setState(161);
						match(T__4);
						setState(163);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << VoidLiteral) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << SingleQuoteString) | (1L << DoubleQuoteString) | (1L << NullLiteral) | (1L << Identifier) | (1L << ResourceReference))) != 0)) {
							{
							setState(162);
							((MethodInvocationContext)_localctx).args = expressionList();
							}
						}

						setState(165);
						match(T__5);
						}
						break;
					case 17:
						{
						_localctx = new InstanceOfOpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(166);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(167);
						match(T__24);
						setState(168);
						type();
						}
						break;
					}
					} 
				}
				setState(173);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
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

	public static class ClassExtractionContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ClassExtractionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classExtraction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).enterClassExtraction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).exitClassExtraction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BindingExpressionVisitor ) return ((BindingExpressionVisitor<? extends T>)visitor).visitClassExtraction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassExtractionContext classExtraction() throws RecognitionException {
		ClassExtractionContext _localctx = new ClassExtractionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_classExtraction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			type();
			setState(175);
			match(T__6);
			setState(176);
			match(T__35);
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

	public static class ExpressionListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).enterExpressionList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).exitExpressionList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BindingExpressionVisitor ) return ((BindingExpressionVisitor<? extends T>)visitor).visitExpressionList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionListContext expressionList() throws RecognitionException {
		ExpressionListContext _localctx = new ExpressionListContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_expressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			expression(0);
			setState(183);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(179);
				match(T__0);
				setState(180);
				expression(0);
				}
				}
				setState(185);
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

	public static class LiteralContext extends ParserRuleContext {
		public JavaLiteralContext javaLiteral() {
			return getRuleContext(JavaLiteralContext.class,0);
		}
		public StringLiteralContext stringLiteral() {
			return getRuleContext(StringLiteralContext.class,0);
		}
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BindingExpressionVisitor ) return ((BindingExpressionVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_literal);
		try {
			setState(188);
			switch (_input.LA(1)) {
			case IntegerLiteral:
			case FloatingPointLiteral:
			case BooleanLiteral:
			case CharacterLiteral:
			case NullLiteral:
				enterOuterAlt(_localctx, 1);
				{
				setState(186);
				javaLiteral();
				}
				break;
			case SingleQuoteString:
			case DoubleQuoteString:
				enterOuterAlt(_localctx, 2);
				{
				setState(187);
				stringLiteral();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(BindingExpressionParser.Identifier, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BindingExpressionVisitor ) return ((BindingExpressionVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			match(Identifier);
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

	public static class JavaLiteralContext extends ParserRuleContext {
		public TerminalNode IntegerLiteral() { return getToken(BindingExpressionParser.IntegerLiteral, 0); }
		public TerminalNode FloatingPointLiteral() { return getToken(BindingExpressionParser.FloatingPointLiteral, 0); }
		public TerminalNode BooleanLiteral() { return getToken(BindingExpressionParser.BooleanLiteral, 0); }
		public TerminalNode NullLiteral() { return getToken(BindingExpressionParser.NullLiteral, 0); }
		public TerminalNode CharacterLiteral() { return getToken(BindingExpressionParser.CharacterLiteral, 0); }
		public JavaLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_javaLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).enterJavaLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).exitJavaLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BindingExpressionVisitor ) return ((BindingExpressionVisitor<? extends T>)visitor).visitJavaLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JavaLiteralContext javaLiteral() throws RecognitionException {
		JavaLiteralContext _localctx = new JavaLiteralContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_javaLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << NullLiteral))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
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

	public static class StringLiteralContext extends ParserRuleContext {
		public TerminalNode SingleQuoteString() { return getToken(BindingExpressionParser.SingleQuoteString, 0); }
		public TerminalNode DoubleQuoteString() { return getToken(BindingExpressionParser.DoubleQuoteString, 0); }
		public StringLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).enterStringLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).exitStringLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BindingExpressionVisitor ) return ((BindingExpressionVisitor<? extends T>)visitor).visitStringLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringLiteralContext stringLiteral() throws RecognitionException {
		StringLiteralContext _localctx = new StringLiteralContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_stringLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			_la = _input.LA(1);
			if ( !(_la==SingleQuoteString || _la==DoubleQuoteString) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
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

	public static class ExplicitGenericInvocationContext extends ParserRuleContext {
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public ExplicitGenericInvocationSuffixContext explicitGenericInvocationSuffix() {
			return getRuleContext(ExplicitGenericInvocationSuffixContext.class,0);
		}
		public ExplicitGenericInvocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_explicitGenericInvocation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).enterExplicitGenericInvocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).exitExplicitGenericInvocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BindingExpressionVisitor ) return ((BindingExpressionVisitor<? extends T>)visitor).visitExplicitGenericInvocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExplicitGenericInvocationContext explicitGenericInvocation() throws RecognitionException {
		ExplicitGenericInvocationContext _localctx = new ExplicitGenericInvocationContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_explicitGenericInvocation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			typeArguments();
			setState(197);
			explicitGenericInvocationSuffix();
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

	public static class TypeArgumentsContext extends ParserRuleContext {
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public TypeArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeArguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).enterTypeArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).exitTypeArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BindingExpressionVisitor ) return ((BindingExpressionVisitor<? extends T>)visitor).visitTypeArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeArgumentsContext typeArguments() throws RecognitionException {
		TypeArgumentsContext _localctx = new TypeArgumentsContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_typeArguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			match(T__23);
			setState(200);
			type();
			setState(205);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(201);
				match(T__0);
				setState(202);
				type();
				}
				}
				setState(207);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(208);
			match(T__22);
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

	public static class TypeContext extends ParserRuleContext {
		public ClassOrInterfaceTypeContext classOrInterfaceType() {
			return getRuleContext(ClassOrInterfaceTypeContext.class,0);
		}
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BindingExpressionVisitor ) return ((BindingExpressionVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_type);
		try {
			int _alt;
			setState(226);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(210);
				classOrInterfaceType();
				setState(215);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(211);
						match(T__8);
						setState(212);
						match(T__9);
						}
						} 
					}
					setState(217);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
				}
				}
				break;
			case T__36:
			case T__37:
			case T__38:
			case T__39:
			case T__40:
			case T__41:
			case T__42:
			case T__43:
				enterOuterAlt(_localctx, 2);
				{
				setState(218);
				primitiveType();
				setState(223);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(219);
						match(T__8);
						setState(220);
						match(T__9);
						}
						} 
					}
					setState(225);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ExplicitGenericInvocationSuffixContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(BindingExpressionParser.Identifier, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public ExplicitGenericInvocationSuffixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_explicitGenericInvocationSuffix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).enterExplicitGenericInvocationSuffix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).exitExplicitGenericInvocationSuffix(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BindingExpressionVisitor ) return ((BindingExpressionVisitor<? extends T>)visitor).visitExplicitGenericInvocationSuffix(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExplicitGenericInvocationSuffixContext explicitGenericInvocationSuffix() throws RecognitionException {
		ExplicitGenericInvocationSuffixContext _localctx = new ExplicitGenericInvocationSuffixContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_explicitGenericInvocationSuffix);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			match(Identifier);
			setState(229);
			arguments();
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

	public static class ArgumentsContext extends ParserRuleContext {
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).enterArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).exitArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BindingExpressionVisitor ) return ((BindingExpressionVisitor<? extends T>)visitor).visitArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			match(T__4);
			setState(233);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << VoidLiteral) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << SingleQuoteString) | (1L << DoubleQuoteString) | (1L << NullLiteral) | (1L << Identifier) | (1L << ResourceReference))) != 0)) {
				{
				setState(232);
				expressionList();
				}
			}

			setState(235);
			match(T__5);
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

	public static class ClassOrInterfaceTypeContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<TypeArgumentsContext> typeArguments() {
			return getRuleContexts(TypeArgumentsContext.class);
		}
		public TypeArgumentsContext typeArguments(int i) {
			return getRuleContext(TypeArgumentsContext.class,i);
		}
		public List<TerminalNode> Identifier() { return getTokens(BindingExpressionParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(BindingExpressionParser.Identifier, i);
		}
		public ClassOrInterfaceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classOrInterfaceType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).enterClassOrInterfaceType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).exitClassOrInterfaceType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BindingExpressionVisitor ) return ((BindingExpressionVisitor<? extends T>)visitor).visitClassOrInterfaceType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassOrInterfaceTypeContext classOrInterfaceType() throws RecognitionException {
		ClassOrInterfaceTypeContext _localctx = new ClassOrInterfaceTypeContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_classOrInterfaceType);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(237);
			identifier();
			setState(239);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(238);
				typeArguments();
				}
				break;
			}
			setState(248);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(241);
					match(T__6);
					setState(242);
					match(Identifier);
					setState(244);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
					case 1:
						{
						setState(243);
						typeArguments();
						}
						break;
					}
					}
					} 
				}
				setState(250);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
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

	public static class PrimitiveTypeContext extends ParserRuleContext {
		public PrimitiveTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitiveType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).enterPrimitiveType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).exitPrimitiveType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BindingExpressionVisitor ) return ((BindingExpressionVisitor<? extends T>)visitor).visitPrimitiveType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimitiveTypeContext primitiveType() throws RecognitionException {
		PrimitiveTypeContext _localctx = new PrimitiveTypeContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_primitiveType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
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

	public static class ResourcesContext extends ParserRuleContext {
		public TerminalNode ResourceReference() { return getToken(BindingExpressionParser.ResourceReference, 0); }
		public ResourceParametersContext resourceParameters() {
			return getRuleContext(ResourceParametersContext.class,0);
		}
		public ResourcesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_resources; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).enterResources(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).exitResources(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BindingExpressionVisitor ) return ((BindingExpressionVisitor<? extends T>)visitor).visitResources(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ResourcesContext resources() throws RecognitionException {
		ResourcesContext _localctx = new ResourcesContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_resources);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253);
			match(ResourceReference);
			setState(255);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(254);
				resourceParameters();
				}
				break;
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

	public static class ResourceParametersContext extends ParserRuleContext {
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public ResourceParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_resourceParameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).enterResourceParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BindingExpressionListener ) ((BindingExpressionListener)listener).exitResourceParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BindingExpressionVisitor ) return ((BindingExpressionVisitor<? extends T>)visitor).visitResourceParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ResourceParametersContext resourceParameters() throws RecognitionException {
		ResourceParametersContext _localctx = new ResourceParametersContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_resourceParameters);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(257);
			match(T__4);
			setState(258);
			expressionList();
			setState(259);
			match(T__5);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 6:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 13);
		case 1:
			return precpred(_ctx, 12);
		case 2:
			return precpred(_ctx, 11);
		case 3:
			return precpred(_ctx, 10);
		case 4:
			return precpred(_ctx, 8);
		case 5:
			return precpred(_ctx, 7);
		case 6:
			return precpred(_ctx, 6);
		case 7:
			return precpred(_ctx, 5);
		case 8:
			return precpred(_ctx, 4);
		case 9:
			return precpred(_ctx, 3);
		case 10:
			return precpred(_ctx, 2);
		case 11:
			return precpred(_ctx, 1);
		case 12:
			return precpred(_ctx, 21);
		case 13:
			return precpred(_ctx, 20);
		case 14:
			return precpred(_ctx, 19);
		case 15:
			return precpred(_ctx, 18);
		case 16:
			return precpred(_ctx, 9);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3<\u0108\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\5\2\61\n\2"+
		"\3\2\5\2\64\n\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\5\4>\n\4\3\5\3\5\3\5\3"+
		"\5\3\6\3\6\3\6\5\6G\n\6\3\6\5\6J\n\6\3\7\3\7\3\7\7\7O\n\7\f\7\16\7R\13"+
		"\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\ba\n\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bm\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00a6\n\b\3"+
		"\b\3\b\3\b\3\b\7\b\u00ac\n\b\f\b\16\b\u00af\13\b\3\t\3\t\3\t\3\t\3\n\3"+
		"\n\3\n\7\n\u00b8\n\n\f\n\16\n\u00bb\13\n\3\13\3\13\5\13\u00bf\n\13\3\f"+
		"\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\20\7\20\u00ce\n"+
		"\20\f\20\16\20\u00d1\13\20\3\20\3\20\3\21\3\21\3\21\7\21\u00d8\n\21\f"+
		"\21\16\21\u00db\13\21\3\21\3\21\3\21\7\21\u00e0\n\21\f\21\16\21\u00e3"+
		"\13\21\5\21\u00e5\n\21\3\22\3\22\3\22\3\23\3\23\5\23\u00ec\n\23\3\23\3"+
		"\23\3\24\3\24\5\24\u00f2\n\24\3\24\3\24\3\24\5\24\u00f7\n\24\7\24\u00f9"+
		"\n\24\f\24\16\24\u00fc\13\24\3\25\3\25\3\26\3\26\5\26\u0102\n\26\3\27"+
		"\3\27\3\27\3\27\3\27\2\3\16\30\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36"+
		" \"$&(*,\2\13\3\2\r\16\3\2\17\20\3\2\21\23\3\2\24\26\3\2\27\32\3\2\34"+
		"\35\4\2\61\64\67\67\3\2\65\66\3\2\'.\u011f\2\63\3\2\2\2\4\65\3\2\2\2\6"+
		"=\3\2\2\2\b?\3\2\2\2\nI\3\2\2\2\fK\3\2\2\2\16l\3\2\2\2\20\u00b0\3\2\2"+
		"\2\22\u00b4\3\2\2\2\24\u00be\3\2\2\2\26\u00c0\3\2\2\2\30\u00c2\3\2\2\2"+
		"\32\u00c4\3\2\2\2\34\u00c6\3\2\2\2\36\u00c9\3\2\2\2 \u00e4\3\2\2\2\"\u00e6"+
		"\3\2\2\2$\u00e9\3\2\2\2&\u00ef\3\2\2\2(\u00fd\3\2\2\2*\u00ff\3\2\2\2,"+
		"\u0103\3\2\2\2.\60\5\16\b\2/\61\5\4\3\2\60/\3\2\2\2\60\61\3\2\2\2\61\64"+
		"\3\2\2\2\62\64\5\b\5\2\63.\3\2\2\2\63\62\3\2\2\2\64\3\3\2\2\2\65\66\7"+
		"\3\2\2\66\67\7\4\2\2\678\7\5\2\289\5\6\4\29\5\3\2\2\2:>\5\24\13\2;>\7"+
		":\2\2<>\5\26\f\2=:\3\2\2\2=;\3\2\2\2=<\3\2\2\2>\7\3\2\2\2?@\5\n\6\2@A"+
		"\7\6\2\2AB\5\16\b\2B\t\3\2\2\2CJ\78\2\2DF\7\7\2\2EG\5\f\7\2FE\3\2\2\2"+
		"FG\3\2\2\2GH\3\2\2\2HJ\7\b\2\2IC\3\2\2\2ID\3\2\2\2J\13\3\2\2\2KP\78\2"+
		"\2LM\7\3\2\2MO\78\2\2NL\3\2\2\2OR\3\2\2\2PN\3\2\2\2PQ\3\2\2\2Q\r\3\2\2"+
		"\2RP\3\2\2\2ST\b\b\1\2TU\7\7\2\2UV\5\16\b\2VW\7\b\2\2Wm\3\2\2\2Xm\5\24"+
		"\13\2Ym\7\60\2\2Zm\5\26\f\2[m\5\20\t\2\\m\5*\26\2]^\78\2\2^`\7\7\2\2_"+
		"a\5\22\n\2`_\3\2\2\2`a\3\2\2\2ab\3\2\2\2bm\7\b\2\2cd\7\7\2\2de\5 \21\2"+
		"ef\7\b\2\2fg\5\16\b\22gm\3\2\2\2hi\t\2\2\2im\5\16\b\21jk\t\3\2\2km\5\16"+
		"\b\20lS\3\2\2\2lX\3\2\2\2lY\3\2\2\2lZ\3\2\2\2l[\3\2\2\2l\\\3\2\2\2l]\3"+
		"\2\2\2lc\3\2\2\2lh\3\2\2\2lj\3\2\2\2m\u00ad\3\2\2\2no\f\17\2\2op\t\4\2"+
		"\2p\u00ac\5\16\b\20qr\f\16\2\2rs\t\2\2\2s\u00ac\5\16\b\17tu\f\r\2\2uv"+
		"\t\5\2\2v\u00ac\5\16\b\16wx\f\f\2\2xy\t\6\2\2y\u00ac\5\16\b\rz{\f\n\2"+
		"\2{|\t\7\2\2|\u00ac\5\16\b\13}~\f\t\2\2~\177\7\36\2\2\177\u00ac\5\16\b"+
		"\n\u0080\u0081\f\b\2\2\u0081\u0082\7\37\2\2\u0082\u00ac\5\16\b\t\u0083"+
		"\u0084\f\7\2\2\u0084\u0085\7 \2\2\u0085\u00ac\5\16\b\b\u0086\u0087\f\6"+
		"\2\2\u0087\u0088\7!\2\2\u0088\u00ac\5\16\b\7\u0089\u008a\f\5\2\2\u008a"+
		"\u008b\7\"\2\2\u008b\u00ac\5\16\b\6\u008c\u008d\f\4\2\2\u008d\u008e\7"+
		"#\2\2\u008e\u008f\5\16\b\2\u008f\u0090\7$\2\2\u0090\u0091\5\16\b\4\u0091"+
		"\u00ac\3\2\2\2\u0092\u0093\f\3\2\2\u0093\u0094\7%\2\2\u0094\u00ac\5\16"+
		"\b\4\u0095\u0096\f\27\2\2\u0096\u0097\7\t\2\2\u0097\u00ac\78\2\2\u0098"+
		"\u0099\f\26\2\2\u0099\u009a\7\n\2\2\u009a\u00ac\78\2\2\u009b\u009c\f\25"+
		"\2\2\u009c\u009d\7\13\2\2\u009d\u009e\5\16\b\2\u009e\u009f\7\f\2\2\u009f"+
		"\u00ac\3\2\2\2\u00a0\u00a1\f\24\2\2\u00a1\u00a2\7\t\2\2\u00a2\u00a3\7"+
		"8\2\2\u00a3\u00a5\7\7\2\2\u00a4\u00a6\5\22\n\2\u00a5\u00a4\3\2\2\2\u00a5"+
		"\u00a6\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00ac\7\b\2\2\u00a8\u00a9\f\13"+
		"\2\2\u00a9\u00aa\7\33\2\2\u00aa\u00ac\5 \21\2\u00abn\3\2\2\2\u00abq\3"+
		"\2\2\2\u00abt\3\2\2\2\u00abw\3\2\2\2\u00abz\3\2\2\2\u00ab}\3\2\2\2\u00ab"+
		"\u0080\3\2\2\2\u00ab\u0083\3\2\2\2\u00ab\u0086\3\2\2\2\u00ab\u0089\3\2"+
		"\2\2\u00ab\u008c\3\2\2\2\u00ab\u0092\3\2\2\2\u00ab\u0095\3\2\2\2\u00ab"+
		"\u0098\3\2\2\2\u00ab\u009b\3\2\2\2\u00ab\u00a0\3\2\2\2\u00ab\u00a8\3\2"+
		"\2\2\u00ac\u00af\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae"+
		"\17\3\2\2\2\u00af\u00ad\3\2\2\2\u00b0\u00b1\5 \21\2\u00b1\u00b2\7\t\2"+
		"\2\u00b2\u00b3\7&\2\2\u00b3\21\3\2\2\2\u00b4\u00b9\5\16\b\2\u00b5\u00b6"+
		"\7\3\2\2\u00b6\u00b8\5\16\b\2\u00b7\u00b5\3\2\2\2\u00b8\u00bb\3\2\2\2"+
		"\u00b9\u00b7\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\23\3\2\2\2\u00bb\u00b9"+
		"\3\2\2\2\u00bc\u00bf\5\30\r\2\u00bd\u00bf\5\32\16\2\u00be\u00bc\3\2\2"+
		"\2\u00be\u00bd\3\2\2\2\u00bf\25\3\2\2\2\u00c0\u00c1\78\2\2\u00c1\27\3"+
		"\2\2\2\u00c2\u00c3\t\b\2\2\u00c3\31\3\2\2\2\u00c4\u00c5\t\t\2\2\u00c5"+
		"\33\3\2\2\2\u00c6\u00c7\5\36\20\2\u00c7\u00c8\5\"\22\2\u00c8\35\3\2\2"+
		"\2\u00c9\u00ca\7\32\2\2\u00ca\u00cf\5 \21\2\u00cb\u00cc\7\3\2\2\u00cc"+
		"\u00ce\5 \21\2\u00cd\u00cb\3\2\2\2\u00ce\u00d1\3\2\2\2\u00cf\u00cd\3\2"+
		"\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d2\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d2"+
		"\u00d3\7\31\2\2\u00d3\37\3\2\2\2\u00d4\u00d9\5&\24\2\u00d5\u00d6\7\13"+
		"\2\2\u00d6\u00d8\7\f\2\2\u00d7\u00d5\3\2\2\2\u00d8\u00db\3\2\2\2\u00d9"+
		"\u00d7\3\2\2\2\u00d9\u00da\3\2\2\2\u00da\u00e5\3\2\2\2\u00db\u00d9\3\2"+
		"\2\2\u00dc\u00e1\5(\25\2\u00dd\u00de\7\13\2\2\u00de\u00e0\7\f\2\2\u00df"+
		"\u00dd\3\2\2\2\u00e0\u00e3\3\2\2\2\u00e1\u00df\3\2\2\2\u00e1\u00e2\3\2"+
		"\2\2\u00e2\u00e5\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e4\u00d4\3\2\2\2\u00e4"+
		"\u00dc\3\2\2\2\u00e5!\3\2\2\2\u00e6\u00e7\78\2\2\u00e7\u00e8\5$\23\2\u00e8"+
		"#\3\2\2\2\u00e9\u00eb\7\7\2\2\u00ea\u00ec\5\22\n\2\u00eb\u00ea\3\2\2\2"+
		"\u00eb\u00ec\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00ee\7\b\2\2\u00ee%\3"+
		"\2\2\2\u00ef\u00f1\5\26\f\2\u00f0\u00f2\5\36\20\2\u00f1\u00f0\3\2\2\2"+
		"\u00f1\u00f2\3\2\2\2\u00f2\u00fa\3\2\2\2\u00f3\u00f4\7\t\2\2\u00f4\u00f6"+
		"\78\2\2\u00f5\u00f7\5\36\20\2\u00f6\u00f5\3\2\2\2\u00f6\u00f7\3\2\2\2"+
		"\u00f7\u00f9\3\2\2\2\u00f8\u00f3\3\2\2\2\u00f9\u00fc\3\2\2\2\u00fa\u00f8"+
		"\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\'\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fd"+
		"\u00fe\t\n\2\2\u00fe)\3\2\2\2\u00ff\u0101\7:\2\2\u0100\u0102\5,\27\2\u0101"+
		"\u0100\3\2\2\2\u0101\u0102\3\2\2\2\u0102+\3\2\2\2\u0103\u0104\7\7\2\2"+
		"\u0104\u0105\5\22\n\2\u0105\u0106\7\b\2\2\u0106-\3\2\2\2\30\60\63=FIP"+
		"`l\u00a5\u00ab\u00ad\u00b9\u00be\u00cf\u00d9\u00e1\u00e4\u00eb\u00f1\u00f6"+
		"\u00fa\u0101";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}