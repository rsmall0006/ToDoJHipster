(function() {
    'use strict';
    angular
        .module('toDoJHipsterApp')
        .factory('Todo', Todo);

    Todo.$inject = ['$resource', 'DateUtils'];

    function Todo ($resource, DateUtils) {
        var resourceUrl =  'api/todos/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    if (data) {
                        data = angular.fromJson(data);
                        data.datetoaccomplish = DateUtils.convertLocalDateFromServer(data.datetoaccomplish);
                    }
                    return data;
                }
            },
            'update': {
                method: 'PUT',
                transformRequest: function (data) {
                    var copy = angular.copy(data);
                    copy.datetoaccomplish = DateUtils.convertLocalDateToServer(copy.datetoaccomplish);
                    return angular.toJson(copy);
                }
            },
            'save': {
                method: 'POST',
                transformRequest: function (data) {
                    var copy = angular.copy(data);
                    copy.datetoaccomplish = DateUtils.convertLocalDateToServer(copy.datetoaccomplish);
                    return angular.toJson(copy);
                }
            }
        });
    }
})();
