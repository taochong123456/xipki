/*
 *
 * Copyright (c) 2013 - 2019 Lijun Liao
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.xipki.ca.server;

import java.util.HashMap;
import java.util.Map;

import org.xipki.ca.api.NameId;

/**
 * TODO.
 * @author Lijun Liao
 * @since 2.2.0
 */

public class CaIdNameMap {

  private final Map<Integer, NameId> idCertprofileMap = new HashMap<>();

  private final Map<Integer, NameId> idPublisherMap = new HashMap<>();

  private final Map<Integer, NameId> idRequestorMap = new HashMap<>();

  private final Map<Integer, NameId> idCaMap = new HashMap<>();

  private final Map<String, NameId> nameCertprofileMap = new HashMap<>();

  private final Map<String, NameId> namePublisherMap = new HashMap<>();

  private final Map<String, NameId> nameRequestorMap = new HashMap<>();

  private final Map<String, NameId> nameCaMap = new HashMap<>();

  public void addCertprofile(NameId nameId) {
    idCertprofileMap.put(nameId.getId(), nameId);
    nameCertprofileMap.put(nameId.getName(), nameId);
  }

  public void addPublisher(NameId nameId) {
    idPublisherMap.put(nameId.getId(), nameId);
    namePublisherMap.put(nameId.getName(), nameId);
  }

  public void addRequestor(NameId nameId) {
    idRequestorMap.put(nameId.getId(), nameId);
    nameRequestorMap.put(nameId.getName(), nameId);
  }

  public void addCa(NameId nameId) {
    idCaMap.put(nameId.getId(), nameId);
    nameCaMap.put(nameId.getName(), nameId);
  }

  public NameId getCertprofile(int id) {
    return idCertprofileMap.get(id);
  }

  public NameId getCertprofile(String name) {
    return nameCertprofileMap.get(name.toLowerCase());
  }

  public NameId getPublisher(int id) {
    return idPublisherMap.get(id);
  }

  public NameId getPublisher(String name) {
    return namePublisherMap.get(name.toLowerCase());
  }

  public NameId getRequestor(int id) {
    return idRequestorMap.get(id);
  }

  public NameId getRequestor(String name) {
    return nameRequestorMap.get(name.toLowerCase());
  }

  public NameId getCa(int id) {
    return idCaMap.get(id);
  }

  public NameId getCa(String name) {
    return nameCaMap.get(name.toLowerCase());
  }

  public String getCertprofileName(int id) {
    NameId nid = idCertprofileMap.get(id);
    return (nid == null) ? null : nid.getName();
  }

  public String getPublisherName(int id) {
    NameId nid = idPublisherMap.get(id);
    return (nid == null) ? null : nid.getName();
  }

  public String getRequestorName(int id) {
    NameId nid = idRequestorMap.get(id);
    return (nid == null) ? null : nid.getName();
  }

  public String getCaName(int id) {
    NameId nid = idCaMap.get(id);
    return (nid == null) ? null : nid.getName();
  }

  public void clearCertprofile() {
    idCertprofileMap.clear();
    nameCertprofileMap.clear();
  }

  public void clearPublisher() {
    idPublisherMap.clear();
    namePublisherMap.clear();
  }

  public void clearRequestor() {
    idRequestorMap.clear();
    nameRequestorMap.clear();
  }

  public void clearCa() {
    idCaMap.clear();
    nameCaMap.clear();
  }

  public NameId removeCertprofile(int id) {
    NameId ident = idCertprofileMap.remove(id);
    if (ident != null) {
      nameCertprofileMap.remove(ident.getName());
    }
    return ident;
  }

  public NameId removeCertprofile(String name) {
    NameId ident = nameCertprofileMap.remove(name.toLowerCase());
    if (ident != null) {
      idCertprofileMap.remove(ident.getId());
    }
    return ident;
  }

  public NameId removePublisher(int id) {
    NameId ident = idPublisherMap.remove(id);
    if (ident != null) {
      namePublisherMap.remove(ident.getName());
    }
    return ident;
  }

  public NameId removePublisher(String name) {
    NameId ident = namePublisherMap.remove(name.toLowerCase());
    if (ident != null) {
      idPublisherMap.remove(ident.getId());
    }
    return ident;
  }

  public NameId removeRequestor(int id) {
    NameId ident = idRequestorMap.remove(id);
    if (ident != null) {
      nameRequestorMap.remove(ident.getName());
    }
    return ident;
  }

  public NameId removeRequestor(String name) {
    NameId ident = nameRequestorMap.remove(name.toLowerCase());
    if (ident != null) {
      idRequestorMap.remove(ident.getId());
    }
    return ident;
  }

  public NameId removeCa(int id) {
    NameId ident = idCaMap.remove(id);
    if (ident != null) {
      nameCaMap.remove(ident.getName());
    }
    return ident;
  }

  public NameId removeCa(String name) {
    NameId ident = nameCaMap.remove(name.toLowerCase());
    if (ident != null) {
      idCaMap.remove(ident.getId());
    }
    return ident;
  }

}
