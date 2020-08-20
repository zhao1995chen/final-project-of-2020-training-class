class Utils {
    /**
     * 设置cookie
     * @param {string} name 
     * @param {string} value 
     * @param {*} days 
     */
    static setCookie(name, value, days) {
        let Days = days || 1;
        let exp = new Date();
        exp.setTime(exp.getTime() + Days * 24 * 60 * 60 * 1000);
        document.cookie = name + "=" + escape(value) + ";path=/;expires=" + exp.toGMTString();
    }
    /**
     * 设置cookie
     * @param {string} name 设置cookie的键值
     * @param {string} value 设置cookie的储存值
     * @param {number} minutes cookie过期时间，单位为分钟
     */
    static setCookieTime(name, value, minutes) {
        let min = minutes || 10;
        let exp = new Date();
        exp.setTime(exp.getTime() + (min * 60 * 1000));
        document.cookie = name + "=" + escape(value) + ";path=/;expires=" + exp.toGMTString();
    }

    /**
     * 依给定键值名称来取得cookie内容值
     * @param {string} name 键值名称
     */
    static getCookie(name) {
        let arr, reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");
        if (arr = document.cookie.match(reg))
            return unescape(arr[2]);
        else
            return null;
    }
    /**
     * 依给定键值名称来删除cookie
     * @param {string} name 键值名称
     */
    static delCookie(name) {
        let exp = new Date();
        exp.setTime(exp.getTime() - (24 * 60 * 60 * 1000));
        console.log(exp.toGMTString());
        document.cookie = name + "=;path=/;expires=" + exp.toGMTString();
    }

    /**
     * 判断输入值是否符合e-mail格式
     * @param {string} str 输入值
     * @returns {boolean} 符合e-mail格式为true，反之为false
     */
    static isEmail(str) {

        const regInvalid = /(@.*@)|(\.\.)|(@\.)|(\.@)|(^\.)/;
        const regValid = /^.+\@(\[?)[a-zA-Z0-9\-\.]+\.([a-zA-Z]{2,3}|[0-9]{1,3})(\]?)$/;

        return (!regInvalid.test(str) && regValid.test(str));

    }
}

export default Utils;
