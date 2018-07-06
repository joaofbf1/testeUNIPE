package br.com.unipe.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.sentry.Sentry;

public class LoggerPadrao {
	
	private static Logger logErro = LoggerFactory.getLogger("erros");
	private static Logger logInfo = LoggerFactory.getLogger("informacao");
	private static Logger logInfoStartApplication = LoggerFactory.getLogger("start_application");
	private static Logger logDebug = LoggerFactory.getLogger("depuracao");
	private static Logger logTransacao = LoggerFactory.getLogger("transacao");

	static {
		Sentry.init("https://9284cf4cd7d8437ead553956ea2f4a8c@sentry.io/1238325");
	}
	public static void info(String mensagem, Object ... args){
		logInfo.info(mensagem, args);
		Sentry.capture("Captura1");
	}
	
	public static void info(String mensagem){
		logInfo.info(mensagem);
		Sentry.capture("Captura2");
	}
	
	public static void transacao(String mensagem){
		logTransacao.info("loggerTransacao - "+mensagem);
		Sentry.capture("Captura3");
	}
	
	public static void debug(String mensagem, Object ... args){
		logDebug.debug(mensagem, args);
		Sentry.capture("Captura4");
	}
	
	public static void debug(String mensagem, long time){
		logDebug.debug(mensagem+ " - "+(System.currentTimeMillis()-time)+" ms");
		Sentry.capture("Captura5");
	}
	

	public static void error(String mensagem, Exception e) {
		logErro.error(mensagem, e);
		Sentry.capture("Captura6");
	}

	public static void error(String string) {
		logErro.error(string);
		Sentry.capture("Captura7");
	}
	
	public static void info(String mensagem, long time, Object ... args){
		logInfo.info(mensagem+" - "+(System.currentTimeMillis()-time)+" ms", args);
		Sentry.capture("Captura8");
	}
	
	public static void info(String mensagem, long time){
		logInfo.info(mensagem+ " - "+(System.currentTimeMillis()-time)+" ms");
		Sentry.capture("Captura9");
	}
	
	public static void transacao(String mensagem, long time){
		logTransacao.info("loggerTransacao - "+mensagem+" - "+(System.currentTimeMillis()-time)+" ms");
		Sentry.capture("Captura10");
	}
	
	public static void debug(String mensagem, long time, Object ... args){
		logDebug.debug(mensagem+" - "+(System.currentTimeMillis()-time)+" ms", args);
		Sentry.capture("Captura11");
	}

	public static void error(String mensagem, Exception e, long time) {
		logErro.error(mensagem+" - "+(System.currentTimeMillis()-time)+" ms", e);
		Sentry.capture("Captura12");
	}

	public static void error(String string, long time) {
		logErro.error(string+" - "+(System.currentTimeMillis()-time)+" ms");
		Sentry.capture("Captura13");
	}
	
	public static void startApplication(String mensagem, Object ... args){
		logInfoStartApplication.info(mensagem, args);
		Sentry.capture("Iniciando Aplicação");
	}
}
