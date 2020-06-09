package com.onarandombox.MultiverseCore.utils.webpaste;

import java.util.Map;

/**
 * An interface to a web-based text-pasting service. Classes implementing this
 * interface should implement its methods to send data to an online text-sharing
 * service, such as pastebin.com. Conventionally, a paste is accomplished by (given
 * some PasteService instance ps):
 *
 * {@code ps.postData(ps.encodeData(someString), ps.getPostURL());}
 *
 * Services that provide a distinction between "public" and "private" pastes
 * should implement a custom constructor that specifies which kind the PasteService
 * instance is submitting; an example of this is the PastebinPasteService class.
 */
public abstract class PasteService extends HttpAPIClient {
    public PasteService(String url, String accessToken) {
        super(url, accessToken);
    }

    /**
     * Post data to the Web.
     *
     * @param data A URL-encoded String containing the full request to post to
     *             the given URL. Can be the result of calling #encodeData().
     * @throws PasteFailedException When pasting/posting the data failed.
     * @return The URL at which the new paste is visible.
     */
    public abstract String postData(String data) throws PasteFailedException;

    /**
     * Post data to the Web.
     *
     * @param data A URL-encoded Map containing the full request to post to
     *             the given URL. Can be the result of calling #encodeData().
     * @throws PasteFailedException When pasting/posting the data failed.
     * @return The URL at which the new paste is visible.
     */
    public abstract String postData(Map<String, String> data) throws PasteFailedException;

    /**
     * Does this service support uploading multiple files.
     *
     * Newer services like gist support multi-file which allows us to upload configs
     * in addition to the standard logs.
     *
     * @return True if this service supports multiple file upload.
     */
    public abstract boolean supportsMultiFile();
}
