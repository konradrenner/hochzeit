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
package at.kuk.hochzeit.hochzeit.web;

import java.security.Principal;

/**
 *
 * @author Konrad Renner
 */
public enum UserMapping {
    KONI("Konrad Renner"),
    HOCHZEIT000("Verwandtschaft Mannersdorf"),
    HOCHZEIT100("Ernst Boehm"),
    HOCHZEIT110("Bernhard Boehm"),
    HOCHZEIT120("Brigitte Art"),
    HOCHZEIT130("Wolfgang Bauer"),
    HOCHZEIT140("Stefan Boehm"),
    HOCHZEIT150("Konstantin Boehm"),
    HOCHZEIT170("Christine Art"),
    HOCHZEIT180("Patrick Art"),
    HOCHZEIT190("Rudolf Bauer jun."),
    HOCHZEIT195("Rudolf Bauer"),
    HOCHZEIT200("Rosemarie Schiefer"),
    HOCHZEIT210("Maria Richter"),
    HOCHZEIT220("Dietmar Schiefer"),
    HOCHZEIT230("Gerald Schiefer"),
    HOCHZEIT240("Siegfried Hoebert"),
    HOCHZEIT250("Gertraud Pahr"),
    HOCHZEIT260("Roland Laschober"),
    HOCHZEIT270("Thomas Pahr"),
    HOCHZEIT280("Juergen Pahr"),
    HOCHZEIT290("Alexander Laschober"),
    HOCHZEIT300("Jasmin Pahr"),
    HOCHZEIT310("Sandra Wieser"),
    HOCHZEIT320("Marc Laschober"),
    HOCHZEIT330("Nina Pertl"),
    HOCHZEIT340("Berta Beck"),
    HOCHZEIT350("Gerhard Puhr"),
    HOCHZEIT360("Helmut Puhr"),
    HOCHZEIT370("Harald Puhr"),
    HOCHZEIT380("Birgit Puhr-Benkoe"),
    HOCHZEIT390("Barbara Puhr-Gaal"),
    HOCHZEIT400("Andrea Schuh"),
    HOCHZEIT410("Helene"),
    HOCHZEIT420("Tanja Huetter"),
    HOCHZEIT430("Elisabeth Krutzler"),
    HOCHZEIT440("Barbara Ehrhardt"),
    HOCHZEIT450("Jennifer Rehberger"),
    HOCHZEIT470("Verena Pertl"),
    HOCHZEIT480("Patrick Fleck"),
    HOCHZEIT490("Roland Schranz"),
    HOCHZEIT500("Christian Boehm"),
    HOCHZEIT510("Andreas Baldauf"),
    HOCHZEIT520("Harald Haselbauer"),
    HOCHZEIT530("Michael Schranz"),
    HOCHZEIT540("Gerhard Rohrboeck"),
    HOCHZEIT550("Benjamin Gamauf"),
    HOCHZEIT560("Manfred Wohlmuth"),
    HOCHZEIT570("Helmut Seidl");


    private final String value;


    private UserMapping(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static String resolve(Principal user) {
        
        String userName = user.getName().toUpperCase();
        
        for(UserMapping mapping : values()){
            if (userName.equals(mapping.toString())) {
                return mapping.getValue();
            }
        }
        
        return userName;
    }
}
