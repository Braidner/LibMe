'use strict';
var gulp = require('gulp');
var jshint = require('gulp-jshint');
var concat = require('gulp-concat');
var rename = require('gulp-rename');
var uglify = require('gulp-uglify');
var sourcemaps = require('gulp-sourcemaps');
var ngAnnotate = require('gulp-ng-annotate');

// Линтинг файлов
gulp.task('lint', function() {
    gulp.src('./app/**/*.js')
        .pipe(jshint())
        .pipe(jshint.reporter('default'));
});

// Конкатенация и минификация файлов
gulp.task('minify', function(){
    gulp.src('./app/**/*.js')
        .pipe(sourcemaps.init())
        .pipe(concat('all.js'))
        .pipe(gulp.dest('./dist'))
        .pipe(rename('all.min.js'))
        .pipe(ngAnnotate())
        .pipe(uglify())
        .pipe(sourcemaps.write())
        .pipe(gulp.dest('./dist'));
});

// Действия по умолчанию
gulp.task('default', function(){
    gulp.run('lint', 'minify');

    // Отслеживаем изменения в файлах
    gulp.watch("./app/**/*.js", function(event){
        gulp.run('lint', 'minify');
    });
});