#set folderName = "jbd", "jbd2"
#set cFileName = "checkpoint", "recovery", "journal", "revoke", "commit", "transaction"

#set spinWrite = "spin", "write"
#set jbd2Prefix = "", "jbd2_"
#set bhsPrefix = "", "journal->j_chkpt_"

#set CAP_FILENAME = "JBD", "JBD2"
#set jfsjbd2 = "JFS", "JBD2"
#set tagbyte = "sizeof(journal_block_tag_t)", "tag_bytes" 
#set typeChange = "int", "long long"
#set intlong = "int", "long"
#set intulonglong = "int", "unsigned long long"
#set u2lu = "u", "lu"
#set u2llu = "u", "llu"
#set u2ld = "u", "ld"
#set 32to16 = "32", "16"
#set 3to4 = "4", "3"
#set 5to4 = "5", "4"
#set 5to6 = "6", "5"

#set kjournald = "kjournald", "kjournald2"
#set kjournaldJBD2 = "\"kjournald\"", "\"jbd2/%s\", journal->j_devname"
#set spinRead = "spin", "read"
#set failNull = "goto fail;", "return NULL;"
#set journalJbd2 = "journal", "jbd2"
#set journalDevName = "journal_dev_name(journal, b)", "journal->j_devname"

#set blockHash = "block", "hash"

#while folderName, spinWrite, jbd2Prefix, bhsPrefix, CAP_FILENAME, jfsjbd2, tagbyte, typeChange, intlong, intulonglong, u2lu, u2ld, u2llu, 32to16, kjournald, spinRead, failNull, journalJbd2, journalDevName, blockHash, kjournaldJBD2, 3to4, 5to4, 5to6
	#while cFileName
		#output "output/"?@folderName?"/"?@cFileName?".c"
		#adapt: ?@cFileName?".spc"
			#insert copyright
/*
 * linux/fs/?@folderName?/?@cFileName?".c"
 *
 * Copyright 1999 Red Hat Software --- All Rights Reserved
 * Written by Stephen C. Tweedie <sct@redhat.com>, 1999
 *
 * Copyright 1999 Red Hat Software --- All Rights Reserved
 *
 * This file is part of the Linux kernel and is made available under
 * the terms of the GNU General Public License, version 2, or at your
 * option, any later version, incorporated herein by reference.
			#endinsert
		#endadapt
	#endwhile
#endwhile
