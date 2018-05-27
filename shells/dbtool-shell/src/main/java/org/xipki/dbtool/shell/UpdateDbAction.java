/*
 *
 * Copyright (c) 2013 - 2018 Lijun Liao
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

package org.xipki.dbtool.shell;

import org.apache.karaf.shell.api.action.Command;
import org.apache.karaf.shell.api.action.lifecycle.Service;
import org.xipki.common.util.ParamUtil;
import org.xipki.dbtool.LiquibaseDatabaseConf;
import org.xipki.dbtool.LiquibaseMain;

/**
 * TODO.
 * @author Lijun Liao
 * @since 2.0.0
 */

@Command(scope = "xi", name = "updatedb", description = "update the database schema")
@Service
public class UpdateDbAction extends LiquibaseAction {

  @Override
  protected Object execute0() throws Exception {
    LiquibaseDatabaseConf dbConf = getDatabaseConf();
    update(dbConf, dbSchemaFile);
    return null;
  }

  protected void update(LiquibaseDatabaseConf dbConf, String schemaFile) throws Exception {
    ParamUtil.requireNonNull("dbConf", dbConf);
    ParamUtil.requireNonNull("schemaFile", schemaFile);

    printDatabaseInfo(dbConf, schemaFile);
    if (!force) {
      if (!confirm("update")) {
        println("cancelled");
        return;
      }
    }

    LiquibaseMain liquibase = new LiquibaseMain(dbConf, schemaFile);
    try {
      liquibase.init(logLevel, logFile);
      liquibase.update();
    } finally {
      liquibase.shutdown();
    }

  }

}