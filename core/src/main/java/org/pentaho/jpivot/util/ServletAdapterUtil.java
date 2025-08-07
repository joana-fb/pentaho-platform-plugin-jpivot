/*! ******************************************************************************
 *
 * Pentaho
 *
 * Copyright (C) 2024 by Hitachi Vantara, LLC : http://www.pentaho.com
 *
 * Use of this software is governed by the Business Source License included
 * in the LICENSE.TXT file.
 *
 * Change Date: 2029-07-20
 ******************************************************************************/

package org.pentaho.jpivot.util;

import org.pentaho.platform.web.http.request.HttpRequestParameterProvider;

/**
 * Utility class to help bridge between javax and jakarta servlet APIs
 */
public class ServletAdapterUtil {
    
    /**
     * Creates an HttpRequestParameterProvider from a javax.servlet request by adapting it
     */
    public static HttpRequestParameterProvider createRequestParameterProvider(javax.servlet.http.HttpServletRequest javaxRequest) {
        // Create a simple adapter that implements the minimal interface needed
        jakarta.servlet.http.HttpServletRequest jakartaRequest = new jakarta.servlet.http.HttpServletRequest() {
            
            @Override
            public String getParameter(String name) {
                return javaxRequest.getParameter(name);
            }
            
            @Override
            public java.util.Enumeration<String> getParameterNames() {
                return javaxRequest.getParameterNames();
            }
            
            @Override
            public String[] getParameterValues(String name) {
                return javaxRequest.getParameterValues(name);
            }
            
            @Override
            public java.util.Map<String, String[]> getParameterMap() {
                return javaxRequest.getParameterMap();
            }
            
            @Override
            public Object getAttribute(String name) {
                return javaxRequest.getAttribute(name);
            }
            
            @Override
            public void setAttribute(String name, Object value) {
                javaxRequest.setAttribute(name, value);
            }
            
            @Override
            public void removeAttribute(String name) {
                javaxRequest.removeAttribute(name);
            }
            
            @Override
            public java.util.Enumeration<String> getAttributeNames() {
                return javaxRequest.getAttributeNames();
            }
            
            // Minimal implementations for required methods - not used by HttpRequestParameterProvider
            @Override public String getAuthType() { return javaxRequest.getAuthType(); }
            @Override public jakarta.servlet.http.Cookie[] getCookies() { return new jakarta.servlet.http.Cookie[0]; }
            @Override public long getDateHeader(String name) { return javaxRequest.getDateHeader(name); }
            @Override public String getHeader(String name) { return javaxRequest.getHeader(name); }
            @Override public java.util.Enumeration<String> getHeaders(String name) { return javaxRequest.getHeaders(name); }
            @Override public java.util.Enumeration<String> getHeaderNames() { return javaxRequest.getHeaderNames(); }
            @Override public int getIntHeader(String name) { return javaxRequest.getIntHeader(name); }
            @Override public String getMethod() { return javaxRequest.getMethod(); }
            @Override public String getPathInfo() { return javaxRequest.getPathInfo(); }
            @Override public String getPathTranslated() { return javaxRequest.getPathTranslated(); }
            @Override public String getContextPath() { return javaxRequest.getContextPath(); }
            @Override public String getQueryString() { return javaxRequest.getQueryString(); }
            @Override public String getRemoteUser() { return javaxRequest.getRemoteUser(); }
            @Override public boolean isUserInRole(String role) { return javaxRequest.isUserInRole(role); }
            @Override public java.security.Principal getUserPrincipal() { return javaxRequest.getUserPrincipal(); }
            @Override public String getRequestedSessionId() { return javaxRequest.getRequestedSessionId(); }
            @Override public String getRequestURI() { return javaxRequest.getRequestURI(); }
            @Override public StringBuffer getRequestURL() { return javaxRequest.getRequestURL(); }
            @Override public String getServletPath() { return javaxRequest.getServletPath(); }
            @Override public jakarta.servlet.http.HttpSession getSession(boolean create) { return null; }
            @Override public jakarta.servlet.http.HttpSession getSession() { return null; }
            @Override public String changeSessionId() { return null; }
            @Override public boolean isRequestedSessionIdValid() { return javaxRequest.isRequestedSessionIdValid(); }
            @Override public boolean isRequestedSessionIdFromCookie() { return javaxRequest.isRequestedSessionIdFromCookie(); }
            @Override public boolean isRequestedSessionIdFromURL() { return javaxRequest.isRequestedSessionIdFromURL(); }
            @Override public boolean authenticate(jakarta.servlet.http.HttpServletResponse response) { return false; }
            @Override public void login(String username, String password) {}
            @Override public void logout() {}
            @Override public java.util.Collection<jakarta.servlet.http.Part> getParts() { return null; }
            @Override public jakarta.servlet.http.Part getPart(String name) { return null; }
            @Override public <T extends jakarta.servlet.http.HttpUpgradeHandler> T upgrade(Class<T> handlerClass) { return null; }
            @Override public String getCharacterEncoding() { return javaxRequest.getCharacterEncoding(); }
            @Override public void setCharacterEncoding(String env) throws java.io.UnsupportedEncodingException { javaxRequest.setCharacterEncoding(env); }
            @Override public int getContentLength() { return javaxRequest.getContentLength(); }
            @Override public long getContentLengthLong() { return javaxRequest.getContentLength(); }
            @Override public String getContentType() { return javaxRequest.getContentType(); }
            @Override public jakarta.servlet.ServletInputStream getInputStream() { return null; }
            @Override public String getProtocol() { return javaxRequest.getProtocol(); }
            @Override public String getScheme() { return javaxRequest.getScheme(); }
            @Override public String getServerName() { return javaxRequest.getServerName(); }
            @Override public int getServerPort() { return javaxRequest.getServerPort(); }
            @Override public java.io.BufferedReader getReader() { try { return javaxRequest.getReader(); } catch (Exception e) { return null; } }
            @Override public String getRemoteAddr() { return javaxRequest.getRemoteAddr(); }
            @Override public String getRemoteHost() { return javaxRequest.getRemoteHost(); }
            @Override public java.util.Locale getLocale() { return javaxRequest.getLocale(); }
            @Override public java.util.Enumeration<java.util.Locale> getLocales() { return javaxRequest.getLocales(); }
            @Override public boolean isSecure() { return javaxRequest.isSecure(); }
            @Override public jakarta.servlet.RequestDispatcher getRequestDispatcher(String path) { return null; }
            @Override public int getRemotePort() { return javaxRequest.getRemotePort(); }
            @Override public String getLocalName() { return javaxRequest.getLocalName(); }
            @Override public String getLocalAddr() { return javaxRequest.getLocalAddr(); }
            @Override public int getLocalPort() { return javaxRequest.getLocalPort(); }
            @Override public jakarta.servlet.ServletContext getServletContext() { return null; }
            @Override public jakarta.servlet.AsyncContext startAsync() { return null; }
            @Override public jakarta.servlet.AsyncContext startAsync(jakarta.servlet.ServletRequest servletRequest, jakarta.servlet.ServletResponse servletResponse) { return null; }
            @Override public boolean isAsyncStarted() { return false; }
            @Override public boolean isAsyncSupported() { return false; }
            @Override public jakarta.servlet.AsyncContext getAsyncContext() { return null; }
            @Override public jakarta.servlet.DispatcherType getDispatcherType() { return jakarta.servlet.DispatcherType.REQUEST; }
            @Override public String getRequestId() { return null; }
            @Override public String getProtocolRequestId() { return null; }
            @Override public jakarta.servlet.ServletConnection getServletConnection() { return null; }
        };
        
        return new HttpRequestParameterProvider(jakartaRequest);
    }
    
    /**
     * Creates a jakarta.servlet.http.HttpServletRequest adapter from a javax.servlet request
     */
    public static jakarta.servlet.http.HttpServletRequest createJakartaRequest(javax.servlet.http.HttpServletRequest javaxRequest) {
        // Create a simple adapter that implements the minimal interface needed
        return new jakarta.servlet.http.HttpServletRequest() {
            
            @Override
            public String getParameter(String name) {
                return javaxRequest.getParameter(name);
            }
            
            @Override
            public java.util.Enumeration<String> getParameterNames() {
                return javaxRequest.getParameterNames();
            }
            
            @Override
            public String[] getParameterValues(String name) {
                return javaxRequest.getParameterValues(name);
            }
            
            @Override
            public java.util.Map<String, String[]> getParameterMap() {
                return javaxRequest.getParameterMap();
            }
            
            @Override
            public Object getAttribute(String name) {
                return javaxRequest.getAttribute(name);
            }
            
            @Override
            public void setAttribute(String name, Object value) {
                javaxRequest.setAttribute(name, value);
            }
            
            @Override
            public void removeAttribute(String name) {
                javaxRequest.removeAttribute(name);
            }
            
            @Override
            public java.util.Enumeration<String> getAttributeNames() {
                return javaxRequest.getAttributeNames();
            }
            
            // Minimal implementations for required methods - not used by getNewAnalysisViewRuntime
            @Override public String getAuthType() { return javaxRequest.getAuthType(); }
            @Override public jakarta.servlet.http.Cookie[] getCookies() { return new jakarta.servlet.http.Cookie[0]; }
            @Override public long getDateHeader(String name) { return javaxRequest.getDateHeader(name); }
            @Override public String getHeader(String name) { return javaxRequest.getHeader(name); }
            @Override public java.util.Enumeration<String> getHeaders(String name) { return javaxRequest.getHeaders(name); }
            @Override public java.util.Enumeration<String> getHeaderNames() { return javaxRequest.getHeaderNames(); }
            @Override public int getIntHeader(String name) { return javaxRequest.getIntHeader(name); }
            @Override public String getMethod() { return javaxRequest.getMethod(); }
            @Override public String getPathInfo() { return javaxRequest.getPathInfo(); }
            @Override public String getPathTranslated() { return javaxRequest.getPathTranslated(); }
            @Override public String getContextPath() { return javaxRequest.getContextPath(); }
            @Override public String getQueryString() { return javaxRequest.getQueryString(); }
            @Override public String getRemoteUser() { return javaxRequest.getRemoteUser(); }
            @Override public boolean isUserInRole(String role) { return javaxRequest.isUserInRole(role); }
            @Override public java.security.Principal getUserPrincipal() { return javaxRequest.getUserPrincipal(); }
            @Override public String getRequestedSessionId() { return javaxRequest.getRequestedSessionId(); }
            @Override public String getRequestURI() { return javaxRequest.getRequestURI(); }
            @Override public StringBuffer getRequestURL() { return javaxRequest.getRequestURL(); }
            @Override public String getServletPath() { return javaxRequest.getServletPath(); }
            @Override public jakarta.servlet.http.HttpSession getSession(boolean create) { return null; }
            @Override public jakarta.servlet.http.HttpSession getSession() { return null; }
            @Override public String changeSessionId() { return null; }
            @Override public boolean isRequestedSessionIdValid() { return javaxRequest.isRequestedSessionIdValid(); }
            @Override public boolean isRequestedSessionIdFromCookie() { return javaxRequest.isRequestedSessionIdFromCookie(); }
            @Override public boolean isRequestedSessionIdFromURL() { return javaxRequest.isRequestedSessionIdFromURL(); }
            @Override public boolean authenticate(jakarta.servlet.http.HttpServletResponse response) { return false; }
            @Override public void login(String username, String password) {}
            @Override public void logout() {}
            @Override public java.util.Collection<jakarta.servlet.http.Part> getParts() { return null; }
            @Override public jakarta.servlet.http.Part getPart(String name) { return null; }
            @Override public <T extends jakarta.servlet.http.HttpUpgradeHandler> T upgrade(Class<T> handlerClass) { return null; }
            @Override public String getCharacterEncoding() { return javaxRequest.getCharacterEncoding(); }
            @Override public void setCharacterEncoding(String env) throws java.io.UnsupportedEncodingException { javaxRequest.setCharacterEncoding(env); }
            @Override public int getContentLength() { return javaxRequest.getContentLength(); }
            @Override public long getContentLengthLong() { return javaxRequest.getContentLength(); }
            @Override public String getContentType() { return javaxRequest.getContentType(); }
            @Override public jakarta.servlet.ServletInputStream getInputStream() { return null; }
            @Override public String getProtocol() { return javaxRequest.getProtocol(); }
            @Override public String getScheme() { return javaxRequest.getScheme(); }
            @Override public String getServerName() { return javaxRequest.getServerName(); }
            @Override public int getServerPort() { return javaxRequest.getServerPort(); }
            @Override public java.io.BufferedReader getReader() { try { return javaxRequest.getReader(); } catch (Exception e) { return null; } }
            @Override public String getRemoteAddr() { return javaxRequest.getRemoteAddr(); }
            @Override public String getRemoteHost() { return javaxRequest.getRemoteHost(); }
            @Override public java.util.Locale getLocale() { return javaxRequest.getLocale(); }
            @Override public java.util.Enumeration<java.util.Locale> getLocales() { return javaxRequest.getLocales(); }
            @Override public boolean isSecure() { return javaxRequest.isSecure(); }
            @Override public jakarta.servlet.RequestDispatcher getRequestDispatcher(String path) { return null; }
            @Override public int getRemotePort() { return javaxRequest.getRemotePort(); }
            @Override public String getLocalName() { return javaxRequest.getLocalName(); }
            @Override public String getLocalAddr() { return javaxRequest.getLocalAddr(); }
            @Override public int getLocalPort() { return javaxRequest.getLocalPort(); }
            @Override public jakarta.servlet.ServletContext getServletContext() { return null; }
            @Override public jakarta.servlet.AsyncContext startAsync() { return null; }
            @Override public jakarta.servlet.AsyncContext startAsync(jakarta.servlet.ServletRequest servletRequest, jakarta.servlet.ServletResponse servletResponse) { return null; }
            @Override public boolean isAsyncStarted() { return false; }
            @Override public boolean isAsyncSupported() { return false; }
            @Override public jakarta.servlet.AsyncContext getAsyncContext() { return null; }
            @Override public jakarta.servlet.DispatcherType getDispatcherType() { return jakarta.servlet.DispatcherType.REQUEST; }
            @Override public String getRequestId() { return null; }
            @Override public String getProtocolRequestId() { return null; }
            @Override public jakarta.servlet.ServletConnection getServletConnection() { return null; }
        };
    }
}
