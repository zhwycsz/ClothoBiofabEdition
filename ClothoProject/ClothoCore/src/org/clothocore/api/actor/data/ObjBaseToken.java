/*
 *  Copyright (c) 2010 The Regents of the University of California.
 * 
 *  All rights reserved.
 *  Permission is hereby granted, without written agreement and without
 *  license or royalty fees, to use, copy, modify, and distribute this
 *  software and its documentation for any purpose, provided that the above
 *  copyright notice and the following two paragraphs appear in all copies
 *  of this software.
 * 
 *  IN NO EVENT SHALL THE UNIVERSITY OF CALIFORNIA BE LIABLE TO ANY PARTY
 *  FOR DIRECT, INDIRECT, SPECIAL, INCIDENTAL, OR CONSEQUENTIAL DAMAGES
 *  ARISING OUT OF THE USE OF THIS SOFTWARE AND ITS DOCUMENTATION, EVEN IF
 *  THE UNIVERSITY OF CALIFORNIA HAS BEEN ADVISED OF THE POSSIBILITY OF
 *  SUCH DAMAGE.
 * 
 *  THE UNIVERSITY OF CALIFORNIA SPECIFICALLY DISCLAIMS ANY WARRANTIES,
 *  INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
 *  MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE. THE SOFTWARE
 *  PROVIDED HEREUNDER IS ON AN "AS IS" BASIS, AND THE UNIVERSITY OF
 *  CALIFORNIA HAS NO OBLIGATION TO PROVIDE MAINTENANCE, SUPPORT, UPDATES,
 *  ENHANCEMENTS, OR MODIFICATIONS.
 */
package org.clothocore.api.actor.data;

import org.clothocore.api.data.ObjBase;
import org.clothocore.api.data.ObjType;

/**
 *
 * @author Bing Xia <bxia@bxia.net>
 */
public class ObjBaseToken extends Token {

    public ObjBaseToken(ObjBase data) {
        super(ObjBase.class);
        _data = data;
    }

    protected ObjBase _data;

    public ObjType getObjType() {
        return _data.getType();
    }

    @Override
    public ObjBase getData() {
        return _data;
    }

    @Override
    public boolean setData( Object data ) {
        if(!(data instanceof ObjBase)) {
            return false;
        }
        _data = (ObjBase) data;
        return true;
    }
    
}
