/*
 * Copyright (C) 2016 Konrad Renner
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package at.kuk.hochzeit.hochzeit;

import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

/**
 *
 * @author Konrad Renner
 */
@Stateless
public class HochzeitLogger {

    @Resource
    private SessionContext context;

    public void info(Class<?> clazz, String method, String msg) {
        Logger.getGlobal().log(Level.INFO, "[{0}] - [{1}] - {2}.{3} : {4}", new Object[]{new Timestamp(System.currentTimeMillis()), context.getCallerPrincipal().getName(), clazz.getName(), method, msg});
    }

    public void error(Class<?> clazz, String method, Throwable thrown) {
        StringBuilder stack = new StringBuilder();

        for (StackTraceElement elem : thrown.getStackTrace()) {
            stack.append(elem.toString());
        }

        Logger.getGlobal().log(Level.SEVERE, "[{0}] - [{1}] - {2}.{3} : {4}", new Object[]{new Timestamp(System.currentTimeMillis()), context.getCallerPrincipal().getName(), clazz.getName(), method, stack});
    }
}
