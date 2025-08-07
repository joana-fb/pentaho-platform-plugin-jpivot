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


package org.pentaho.jpivot.proxies;

import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

public class ProxyingHttpSession implements HttpSession {
  HttpSession s;

  public ProxyingHttpSession(HttpSession s) {
    this.s = s;
  }

  @Override
  public Object getAttribute(String arg0) {

    return s.getAttribute(arg0);
  }

  @Override
  public Enumeration<String> getAttributeNames() {
    return s.getAttributeNames();
  }

  @Override
  public long getCreationTime() {
    return s.getCreationTime();
  }

  @Override
  public String getId() {
    return s.getId();
  }

  @Override
  public long getLastAccessedTime() {
    return s.getLastAccessedTime();
  }

  @Override
  public int getMaxInactiveInterval() {
    return s.getMaxInactiveInterval();
  }

  @Override
  public ServletContext getServletContext() {
    return s.getServletContext();
  }

  @Override
  public void invalidate() {
    s.invalidate();
  }

  @Override
  public boolean isNew() {
    return s.isNew();
  }

  @Override
  public void removeAttribute(String arg0) {
    s.removeAttribute(arg0);
  }

  @Override
  public void setAttribute(String arg0, Object arg1) {
    s.setAttribute(arg0, arg1);
  }

  @Override
  public void setMaxInactiveInterval(int arg0) {
    s.setMaxInactiveInterval(arg0);
  }

  // Deprecated methods required by javax.servlet.http.HttpSession
  @Override
  @Deprecated
  public String[] getValueNames() {
    return s.getValueNames();
  }

  @Override
  @Deprecated
  public Object getValue(String name) {
    return s.getValue(name);
  }

  @Override
  @Deprecated
  public void putValue(String name, Object value) {
    s.putValue(name, value);
  }

  @Override
  @Deprecated
  public void removeValue(String name) {
    s.removeValue(name);
  }

  @Override
  @Deprecated
  public javax.servlet.http.HttpSessionContext getSessionContext() {
    return s.getSessionContext();
  }

}
