package br.com.hfsframework.util;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class NetUtil implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	private static final Logger log = LoggerFactory.getLogger(NetUtil.class);

	public static void printIpHost() {
		try {
			// Local address
			log.info("Local IP address : " + InetAddress.getLocalHost().getHostAddress());
			log.info("Local Hostname : " + InetAddress.getLocalHost().getHostName());

			// Remote address
			log.info("Remote IP address : " + InetAddress.getLoopbackAddress().getHostAddress());
			log.info("Remote Hostname : " + InetAddress.getLoopbackAddress().getHostName());

		} catch (UnknownHostException e) {
			log.error(e.getMessage());
		}
	}

	public static String getLocalIPAddress() {
		try {
			return InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			log.error(e.getMessage());
		}
		return "";
	}

	public static String getLocalHostname() {
		try {
			return InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			log.error(e.getMessage());
		}
		return "";
	}

	public static String getRemoteIPAddress() {
		return InetAddress.getLoopbackAddress().getHostAddress();
	}

	public static String getRemoteHostname() {
		return InetAddress.getLoopbackAddress().getHostName();
	}

}
