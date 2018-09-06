/**
 * Created by Administrator on 2017/6/18.
 * 系统urls
 */
var urls = {
    //公共接口
    common: {
        upload: pageContext.ctx + '/file/upload',
        uploadLayEdit: pageContext.ctx + '/file/uploadLayEdit',
        statistic: pageContext.ctx + '/adminUser/manage/statistic'
    },
    login: {
        logout: pageContext.ctx + '/login/manage/logout',
        ajaxLogin: pageContext.ctx + '/login/ajaxLogin',
        updatePwd: pageContext.ctx + '/login/manage/updatePwd',
        index: pageContext.ctx + '/user/index',
        main: pageContext.ctx + '/manage/main',
        client:pageContext.ctx+'/client/save'
    },
    user: {
        distributorPage: pageContext.ctx + '/user/manage/distributorPage',
        chiefPage: pageContext.ctx + '/user/manage/chiefPage',
        editPage: pageContext.ctx + '/user/manage/editPage',
        search: pageContext.ctx + '/user/manage/search',
        searchUser: pageContext.ctx + '/user/manage/searchUser',
        exchangePage: pageContext.ctx + '/user/manage/exchangePage',
        save: pageContext.ctx + '/user/manage/save',
        delete: pageContext.ctx + '/user/manage/delete',
        export: pageContext.ctx + '/user/manage/export',
        exportChief: pageContext.ctx + '/user/manage/exportChief',
        audit: pageContext.ctx + '/user/manage/audit',
        move: pageContext.ctx + '/user/manage/move',
        disChiefPage: pageContext.ctx + '/user/manage/disChiefPage'
    },
    adminUser: {
        initPage: pageContext.ctx + '/adminUser/manage/initPage',
        search: pageContext.ctx + '/adminUser/manage/search',
        save: pageContext.ctx + '/adminUser/manage/save',
        updateStatus: pageContext.ctx + '/adminUser/manage/updateStatus'
    },
    integralFlow: {
        search: pageContext.ctx + '/integralFlow/manage/search'
    },
    integralRule: {
        search: pageContext.ctx + '/integralRule/manage/initPage'
    },
    slide: {
        initPage: pageContext.ctx + '/slide/manage/initPage',
        save: pageContext.ctx + '/slide/manage/save',
        list: pageContext.ctx + '/slide/manage/list',
        delete: pageContext.ctx + '/slide/manage/delete',
        initEditPage: pageContext.ctx + '/slide/manage/initEditPage'
    },
    product: {
        initPage: pageContext.ctx + '/product/manage/initPage',
        save: pageContext.ctx + '/product/manage/save',
        search: pageContext.ctx + '/product/manage/search',
        delete: pageContext.ctx + '/product/manage/delete',
        initEditPage: pageContext.ctx + '/product/manage/initEditPage'
    },
    systemSetting: {
        initEditPage: pageContext.ctx + '/systemSetting/manage/initEditPage',
        save: pageContext.ctx + '/systemSetting/manage/save'
    },
    qrCode: {
        initPage: pageContext.ctx + '/qrCode/manage/initPage',
        save: pageContext.ctx + '/qrCode/manage/save',
        search: pageContext.ctx + '/qrCode/manage/search',
        delete: pageContext.ctx + '/qrCode/manage/delete',
        initEditPage: pageContext.ctx + '/qrCode/manage/initEditPage',
        download: pageContext.ctx + '/qrCode/manage/download'
    },
    qrSetting: {
        initPage: pageContext.ctx + '/qrSetting/manage/initPage',
        save: pageContext.ctx + '/qrSetting/manage/save',
        search: pageContext.ctx + '/qrSetting/manage/search',
        delete: pageContext.ctx + '/qrSetting/manage/delete',
        initEditPage: pageContext.ctx + '/qrSetting/manage/initEditPage'
    },
    suggest: {
        initPage: pageContext.ctx + '/suggest/manage/initPage',
        delete: pageContext.ctx + '/suggest/manage/delete',
        search: pageContext.ctx + '/suggest/manage/search'
    }
};
